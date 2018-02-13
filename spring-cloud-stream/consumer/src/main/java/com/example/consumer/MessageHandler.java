package com.example.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {

    private static final Logger Log = LoggerFactory.getLogger(MessageHandler.class);

    @Bean
    IntegrationFlow integrationOrderFlow(ConsumerChannels channels){
        return IntegrationFlows.from(channels.orders())
                .handle(String.class, (payload, headers) -> {
                    Log.info("order message received: " + payload);
            return null;
        })
        .get();
    }


    @Bean
    IntegrationFlow integrationNotificationFlow(ConsumerChannels channels) {
        return IntegrationFlows.from(channels.notifying())
                .handle(String.class, (payload, headers) -> {
                    Log.info("notification message received: " + payload);
            return null;
        })
        .get();
    }
}
