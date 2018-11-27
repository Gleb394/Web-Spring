package com.gleb.dao;

import com.gleb.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getAll();

    Category getById(Long id);
}
