package com.geekbrains.geekmarket.repositories;

import com.geekbrains.geekmarket.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category , Long> {
    List<Category> findAllByParentIsNull() ;

    List<Category> findAllByParent(Category parent) ;
}
