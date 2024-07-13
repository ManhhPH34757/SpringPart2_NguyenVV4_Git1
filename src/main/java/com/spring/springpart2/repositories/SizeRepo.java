package com.spring.springpart2.repositories;

import com.spring.springpart2.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepo extends JpaRepository<Size, Integer> {
}
