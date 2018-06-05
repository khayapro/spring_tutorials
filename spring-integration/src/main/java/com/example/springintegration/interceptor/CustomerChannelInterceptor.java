package com.example.springintegration.interceptor;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

public class CustomerChannelInterceptor extends ChannelInterceptorAdapter {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        final Message<String> interceptedMessage = MessageBuilder.withPayload(message.getPayload()
                + "message intercepted").build();
        //passing a modified message for our demo
        return super.preSend(interceptedMessage, channel);
    }
}
