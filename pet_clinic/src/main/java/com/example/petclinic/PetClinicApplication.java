package com.example.petclinic;

import com.example.petclinic.controller.SimpleController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class PetClinicApplication {

	public static void main(String[] args) {
		final ApplicationContext ctx = SpringApplication.run(PetClinicApplication.class, args);
		final SimpleController bean = ctx.getBean(SimpleController.class);
		log.warn(bean.hello());
	}
}
