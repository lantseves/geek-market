package com.geekbrains.geekmarket.services;

import com.geekbrains.geekmarket.entities.Category;
import com.geekbrains.geekmarket.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository ;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll() ;
    }

    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElse(null) ;
    }

    public Category getCategoryByTitle(String title) {
        return categoryRepository.findFirstByTitle(title) ;
    }

    public void addCategory(Category category) {
        categoryRepository.save(category) ;
    }

}
