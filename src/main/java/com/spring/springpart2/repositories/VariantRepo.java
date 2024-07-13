package com.spring.springpart2.repositories;

import com.spring.springpart2.entities.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VariantRepo extends JpaRepository<Variant, Integer> {

    List<Variant> findByProductId(Integer id);

    Variant findVariantById(Integer id);

}
