package com.dplaps.catalogs.service;

import com.dplaps.catalogs.dto.CatgTree;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    public Map<Integer, CatgTree> findCatgs();

    public CatgTree findCatg(Integer id);

}
