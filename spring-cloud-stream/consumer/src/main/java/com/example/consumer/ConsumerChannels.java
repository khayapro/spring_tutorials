package com.example.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface ConsumerChannels {

    @Input("orders")
    SubscribableChannel orders();

    @Input("notifying")
    SubscribableChannel notifying();
}
