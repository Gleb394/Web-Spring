package com.gleb.serves;

import com.gleb.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category getById(Long id);
}
