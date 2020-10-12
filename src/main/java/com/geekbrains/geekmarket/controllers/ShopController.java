package com.geekbrains.geekmarket.controllers;

import com.geekbrains.geekmarket.entities.Category;
import com.geekbrains.geekmarket.entities.Product;
import com.geekbrains.geekmarket.services.CategoryService;
import com.geekbrains.geekmarket.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {
    private CategoryService categoryService;
    private ProductService productService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showAllProductList(Model model) {
        List<Category> categoryList = categoryService.getAllCategory() ;
        model.addAttribute("categories" , categoryList) ;
        List<Product> products = productService.getAllProduct() ;
        model.addAttribute("products", products) ;
        return "category" ;
    }

    @GetMapping("/{parentId}")
    public String showAllCategoryByParentId(Model model, @PathVariable("parentId")long parentId) {
        List<Category> categoryList = categoryService.getAllCategoriesByParent(parentId) ;

        if (categoryList.size() > 0) {
            model.addAttribute("categories", categoryList);
            return "categories_list";
        }

        List<Product> products = productService.getListProductByCategories(parentId) ;
        if (products.size() > 0) {
            model.addAttribute("products", products) ;
            return "product-list" ;
        }
        return "categories_list" ;
    }
}
