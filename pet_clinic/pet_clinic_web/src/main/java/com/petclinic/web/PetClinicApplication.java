package com.petclinic.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PetClinicApplication {

	public static void main(String[] args) {
		final ApplicationContext cxt = SpringApplication.run(PetClinicApplication.class, args);
	}
}
