package com.dplaps.catalogs.helper;


import com.dplaps.catalogs.dto.CatgTree;
import com.dplaps.catalogs.models.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ParentChild {
    Map<Integer, CatgTree> resultMap = new HashMap<>();

    public Map<Integer, CatgTree> populateResult(List<Category> catgs) {
        Map<Integer, Category> curMap = new HashMap<>();
        for (Category catg : catgs) {
            Integer c = catg.getId();
            curMap.put(c, catg);
        }
        // to multiple values
        Map<Integer, List<Category>> pcMap = new HashMap<>();
        for (Category catg : catgs) {
            Integer parent = catg.getParentid();
            List<Category> directChilds = pcMap.get(parent);
            if (directChilds == null) {
                directChilds = new ArrayList<>();
                pcMap.put(parent, directChilds);
            }
            directChilds.add(catg);
        }
        for (Category catg : catgs) {
            populateResultUtil(catg.getId(), pcMap, curMap);
        }
        return resultMap;
    }


    private CatgTree populateResultUtil(Integer parent, Map<Integer, List<Category>> pcMap, Map<Integer, Category> curMap) {
        if (!pcMap.containsKey(parent)) {
            CatgTree catgTree = new CatgTree();
            catgTree.setName(curMap.get(parent).getName());
            catgTree.setColor(curMap.get(parent).getColor());
            resultMap.put(parent, catgTree);
            return catgTree;
        } else if (resultMap.containsKey(parent)) {
            return resultMap.get(parent);
        }
        List<Category> directChilds = pcMap.get(parent);
        for (Category catg : directChilds) {
            CatgTree childCatgTree = populateResultUtil(catg.getId(), pcMap, curMap);
            if (resultMap.containsKey(parent)) {
                CatgTree catgTree = resultMap.get(parent);
                List<CatgTree> catgtrees = catgTree.getSubClasses();
                if (catgtrees == null) {
                    catgtrees = new ArrayList<>();
                    catgTree.setSubClasses(catgtrees);
                }
                catgtrees.add(childCatgTree);
            } else {
                CatgTree catgTree = new CatgTree();
                catgTree.setName(curMap.get(parent).getName());
                catgTree.setColor(curMap.get(parent).getColor());
                List<CatgTree> catgtrees = new ArrayList<>();
                catgTree.setSubClasses(catgtrees);
                catgtrees.add(childCatgTree);
                resultMap.put(parent, catgTree);
            }
        }
        return resultMap.get(parent);
    }

}
