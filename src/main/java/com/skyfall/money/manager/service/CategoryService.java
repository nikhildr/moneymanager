package com.skyfall.money.manager.service;

import com.skyfall.money.manager.model.Category;

import java.util.List;

public interface CategoryService {

    public Category addNewCategory(Category category);

    public void deleteCategory(Integer id);

    public Category updateCategory(Category category);

    public List<Category> getAllCategories();
}
