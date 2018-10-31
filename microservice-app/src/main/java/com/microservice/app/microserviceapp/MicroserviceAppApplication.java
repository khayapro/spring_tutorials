package com.microservice.app.microserviceapp;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroserviceAppApplication {

	@Bean
	InitializingBean insertData(final CarRepository repository) {
		return () -> {
			repository.save(new Car("BMW", "420d"));
			repository.save(new Car("BMW", "320d"));
			repository.save(new Car("BMW", "x5"));
		};
	}

	@Bean
	CommandLineRunner lineRunner(final CarRepository repository) {
		return args -> repository.findCarByMake("BMW").forEach(car -> System.out.println(car.getModel()));
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAppApplication.class, args);
	}
}
