package com.example.springbootmicroservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfiguration {

    @Bean(name = "names")
    public List<String> names() {
        return Arrays.asList("Khaya", "Tumi", "Elliot","SomeoneElse");
    }
}
