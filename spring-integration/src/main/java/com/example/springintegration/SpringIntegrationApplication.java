package com.example.springintegration;

import com.example.springintegration.services.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {


	@Autowired
	@Qualifier(value = "inputChannel")
	private DirectChannel inputChannel;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Message message = MessageBuilder.withPayload("Hello World payload")
				.setHeader("key", "hello world header value").build();

		final MessagingTemplate template = new MessagingTemplate();
		final Message messageResponse = template.sendAndReceive(inputChannel, message);
		System.out.println(messageResponse.getPayload());

	}
}
