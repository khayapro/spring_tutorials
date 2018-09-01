package com.example.petclinic.controller;

import org.springframework.stereotype.Controller;

@Controller
public class SimpleController {

    public String hello() {
        return "Hello There from SpringContext";
    }
}
