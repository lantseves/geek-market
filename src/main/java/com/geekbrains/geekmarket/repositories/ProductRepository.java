package com.geekbrains.geekmarket.repositories;

import com.geekbrains.geekmarket.entities.Category;
import com.geekbrains.geekmarket.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll() ;

    Optional<List<Product>> findAllByCategory(Category category) ;
}
