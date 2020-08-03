package com.dplaps.catalogs.service.impl;

import com.dplaps.catalogs.dao.CatgDao;
import com.dplaps.catalogs.dto.CatgTree;
import com.dplaps.catalogs.helper.ParentChild;
import com.dplaps.catalogs.models.Category;
import com.dplaps.catalogs.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CatgDao catgDao;

    @Override
    public Map<Integer, CatgTree> findCatgs() {
        List<Category> catgs = catgDao.findAllCatg();
        ParentChild pc = new ParentChild();
        Map<Integer, CatgTree> resultMap = pc.populateResult(catgs);
        return resultMap;
    }

    @Override
    public CatgTree findCatg(Integer id) {
        List<Category> catgs = catgDao.findAllCatg();
        ParentChild pc = new ParentChild();
        Map<Integer, CatgTree> resultMap = pc.populateResult(catgs);
        return resultMap.get(id);
    }

}