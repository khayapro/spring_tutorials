package com.example.spring5webapp.controllers;

import com.example.spring5webapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private static final String RESPONSE = "books";
    private BookRepository repository;

    @Autowired
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/books")
    public String getBooks(final Model model) {
        model.addAttribute("books", repository.findAll());
        return RESPONSE;
    }


}
