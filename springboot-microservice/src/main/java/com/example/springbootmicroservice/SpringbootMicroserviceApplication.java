package com.example.springbootmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootMicroserviceApplication {

	@Autowired
	@Resource(name = "names")
	private List<String> names;


	@GetMapping("/names")
	public String getNames() {
		return String.join(", ", names);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroserviceApplication.class, args);
	}
}
