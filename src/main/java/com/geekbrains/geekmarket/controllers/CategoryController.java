package com.geekbrains.geekmarket.controllers;

import com.geekbrains.geekmarket.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showAllCategoryParentIsNull(Model model) {
        model.addAttribute("categories" , categoryService.getAllCategoryByParentIsNull()) ;
        return "categories_list" ;
    }

    @GetMapping("/{parentId}")
    public String showAllCategoryByParentId(Model model, @PathVariable("parentId")long parentId) {
        model.addAttribute("categories" , categoryService.getAllCategoriesByParent(parentId)) ;
        return "categories_list" ;
    }
}
