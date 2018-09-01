package com.example.petclinic.services;

import com.example.petclinic.interfaces.GreetingService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String greet() {
        return "Hello Primary Greeting Service";
    }
}
