package com.spring.springpart2.repositories;

import com.spring.springpart2.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepo extends JpaRepository<Color, Integer> {
}
