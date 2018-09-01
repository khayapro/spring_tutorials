package com.example.petclinic.services;

import com.example.petclinic.interfaces.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String greet() {
        return "Hello Primary Greeting Service";
    }
}
