package com.example.petclinic.interfaces;

public interface GreetingService {

    default String greetingSomeone() {
        return "Hello Someone";
    }

    String greet();
}
