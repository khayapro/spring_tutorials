package com.example.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;


@Component
public interface ChannelsProducer {

    /**
     * Our service where a message is sent to, and a message can sent to multiple consumers,
     * but for brevity we have only have two.
     */

    @Output("order")
    MessageChannel orderConsumer();

    @Output("notification")
    MessageChannel notificationConsumer();

}
