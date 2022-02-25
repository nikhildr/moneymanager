package com.skyfall.money.manager.serviceimpl;

import com.skyfall.money.manager.model.Category;
import com.skyfall.money.manager.repository.CategoryRepository;
import com.skyfall.money.manager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category addNewCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = repository.getById(id);
        if (category == null) {
            repository.delete(category);
        }
    }

    @Override
    public Category updateCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }
}
