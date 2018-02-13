package com.example.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannels {

    @Input("orders")
    SubscribableChannel orders();

    @Input("notifying")
    SubscribableChannel notifying();
}
