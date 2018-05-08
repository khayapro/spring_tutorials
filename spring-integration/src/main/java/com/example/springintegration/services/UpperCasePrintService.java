package com.example.springintegration.services;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class UpperCasePrintService {

    public Message<?> print(Message<String> message) {
        System.out.println("message number: " + message.getHeaders().get("messageNumber").toString().toUpperCase());
        System.out.println("received message: " +  message.getPayload().toUpperCase());

        return MessageBuilder.withPayload("New Message Response").build();
    }
}
