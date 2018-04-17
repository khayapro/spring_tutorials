package com.example.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@SpringBootApplication
public class EventDrivenApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventDrivenApplication.class, args);
	}
}
