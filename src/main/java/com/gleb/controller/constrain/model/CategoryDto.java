package com.gleb.controller.constrain.model;

import com.gleb.model.Category;

public class CategoryDto {

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public static CategoryDto of(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }
}
