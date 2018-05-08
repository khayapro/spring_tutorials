package com.example.springintegration;

import com.example.springintegration.services.PrinterGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {


	@Autowired
	private PrinterGateway gateway;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Future<Message<String>>> futures = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			//create a message
			final Message<String> message = MessageBuilder.withPayload("Hello message world payload : " + i)
					.setPriority(i)
					.setHeader("messageNumber", i)
					.build();
			System.out.println("Sending message: " + i);
			futures.add(this.gateway.print(message));
		}

		futures.forEach(f -> {
			try {
				System.out.println("future message number: " + f.get().getHeaders().get("messageNumber"));
				System.out.println("future message: [" + f.get().getPayload() + "]");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
	}
}
