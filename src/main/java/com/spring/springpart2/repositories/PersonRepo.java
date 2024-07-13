package com.spring.springpart2.repositories;

import com.spring.springpart2.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {
}