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

    public List<Category> getAllCategoryByParentIsNull() {
        return categoryRepository.findAllByParentIsNull() ;
    }

    public List<Category> getAllCategoriesByParent(long parentId) {
        Optional<Category> categoryOptional = categoryRepository.findById(parentId) ;
        if (categoryOptional.isPresent()) {
            return categoryRepository.findAllByParent(categoryOptional.get());
        } else {
            return new ArrayList<>() ;
        }
    }
}
