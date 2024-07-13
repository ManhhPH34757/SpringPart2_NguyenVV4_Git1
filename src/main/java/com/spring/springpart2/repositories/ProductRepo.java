package com.spring.springpart2.repositories;

import com.spring.springpart2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    Product findProductById(Integer id);

}
