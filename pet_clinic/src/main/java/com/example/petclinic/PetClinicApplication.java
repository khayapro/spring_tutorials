package com.example.petclinic;

import com.example.petclinic.controller.SimpleController;
import com.example.petclinic.services.PrimaryGreetingService;
import com.example.petclinic.services.SecondGreetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class PetClinicApplication {

	public static void main(String[] args) {
		final ApplicationContext cxt = SpringApplication.run(PetClinicApplication.class, args);
		log.warn("***** : {}", cxt.getBean(SimpleController.class).hello());
		log.warn("***** : {}", cxt.getBean(PrimaryGreetingService.class).greet());
		log.warn("***** : {}", cxt.getBean(SecondGreetingService.class).greet());
	}
}
