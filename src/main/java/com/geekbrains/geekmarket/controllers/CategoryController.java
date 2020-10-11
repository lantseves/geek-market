package com.geekbrains.geekmarket.controllers;

import com.geekbrains.geekmarket.entities.Category;
import com.geekbrains.geekmarket.entities.Role;
import com.geekbrains.geekmarket.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService ;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/showAddForm")
    public String showMyLoginPage(Model theModel) {
        theModel.addAttribute("category", new Category());
        return "new_category";
    }

    @PostMapping("/processAddForm")
    public String processRegistrationForm(@Valid @ModelAttribute("category") Category category,
                                          BindingResult theBindingResult, Model theModel) {
        String categoryTitle = category.getTitle() ;
        if (theBindingResult.hasErrors()) {
            return "new_category";
        }
        Category existing = categoryService.getCategoryByTitle(categoryTitle) ;
        if (existing != null) {
            theModel.addAttribute("category", category);
            theModel.addAttribute("registrationError", "Category name already exists");
            return "new_category";
        }
        categoryService.addCategory(category);
        return "category-confirmation";
    }
}
