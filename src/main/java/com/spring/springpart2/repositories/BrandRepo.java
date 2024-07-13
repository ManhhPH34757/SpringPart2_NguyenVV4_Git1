package com.spring.springpart2.repositories;

import com.spring.springpart2.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Integer> {
}
