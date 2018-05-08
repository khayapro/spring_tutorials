package com.example.springintegration.services;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class PrintService {

    public Message<?> print(Message<String> message) {
        System.out.println("message number: " + message.getHeaders().get("messageNumber"));
        System.out.println("received message: " +  message.getPayload());

        return MessageBuilder.withPayload("New Message Response").build();
    }
}
