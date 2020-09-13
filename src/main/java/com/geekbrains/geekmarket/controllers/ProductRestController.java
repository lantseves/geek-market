package com.geekbrains.geekmarket.controllers;


import com.geekbrains.geekmarket.entities.Product;
import com.geekbrains.geekmarket.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    private ProductService productService ;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id) ;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product) ;
    }


    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product) ;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long productId) {
        productService.deleteProduct(productId) ;
    }
}
