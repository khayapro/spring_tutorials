package com.example.springintegration.services;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import java.util.Map;

public class PrintService {

    public Message<?> print(Message<String> message) {
        System.out.println(message.getPayload());

        for (Map.Entry<String, Object> entry : message.getHeaders().entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        return MessageBuilder.withPayload("New Message Response").build();
    }
}
