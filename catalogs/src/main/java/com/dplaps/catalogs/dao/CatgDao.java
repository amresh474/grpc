package com.dplaps.catalogs.dao;

import com.dplaps.catalogs.models.Category;

import java.util.List;

public interface CatgDao {
    public Category findCatg(Integer id);

    public List<Category> findAllCatg();
}