package com.spring.springpart2.controllers;

import com.spring.springpart2.repositories.PersonRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonManager {
    private final PersonRepo personRepo;

    public PersonManager(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping("/home")
    public String home(final Model model) {
        model.addAttribute("listPerson", personRepo.findAll());
        return "person/home";
    }

}
