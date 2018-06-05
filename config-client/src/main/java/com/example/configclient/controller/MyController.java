package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Value(value = "${owner.user.message}")
    private String message;

    @GetMapping(value = "/message")
    public String message() {
        return message;
    }
}
