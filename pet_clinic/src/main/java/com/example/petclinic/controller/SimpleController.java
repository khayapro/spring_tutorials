package com.example.petclinic.controller;

import com.example.petclinic.interfaces.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SimpleController {

    private GreetingService greetingService;

    @Autowired
    public SimpleController(final GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello() {
        return greetingService.greet();
    }
}
