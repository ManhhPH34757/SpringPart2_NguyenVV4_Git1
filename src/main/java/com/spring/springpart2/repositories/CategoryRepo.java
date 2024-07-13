package com.spring.springpart2.repositories;

import com.spring.springpart2.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
