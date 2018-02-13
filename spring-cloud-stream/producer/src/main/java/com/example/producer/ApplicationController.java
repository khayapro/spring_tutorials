package com.example.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    private MessageChannel orderConsumer;
    private MessageChannel notificationConsumer;

    @Autowired
    public ApplicationController(ChannelsProducer producer) {
        this.orderConsumer = producer.orderConsumer();
        this.notificationConsumer = producer.notificationConsumer();
    }

    @PostMapping("/order/{item}")
    public void placeOrder(@PathVariable final String item){
        final Message<String> orderMessage = MessageBuilder
                .withPayload("Dispatch item: " + item).build();
        final Message<String> notificationMessage = MessageBuilder
                .withPayload("Your order item: " + item  + " received.").build();
        this.orderConsumer.send(orderMessage);
        this.notificationConsumer.send(notificationMessage);
    }
}
