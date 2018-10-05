package com.example.spring5webapp.controllers;

import com.example.spring5webapp.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private static final String RESPONSE = "authors";
    private AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/authors")
    public String getAuthors(final Model model) {
        model.addAttribute("authors", repository.findAll());
        return RESPONSE;
    }
}
