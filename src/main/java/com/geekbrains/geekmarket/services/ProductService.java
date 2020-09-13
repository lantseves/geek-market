package com.geekbrains.geekmarket.services;

import com.geekbrains.geekmarket.entities.Product;
import com.geekbrains.geekmarket.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository ;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(long productId) {
        Optional<Product> productOptional = productRepository.findById(productId) ;
        return productOptional.orElseGet(Product::new);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product) ;
    }

    public void updateProduct(Product product) {
        productRepository.save(product) ;
    }

    public void deleteProduct(long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId) ;
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(productId);
        }
    }
}
