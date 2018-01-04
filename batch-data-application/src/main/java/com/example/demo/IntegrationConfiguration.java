package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.file.Files;
import org.springframework.integration.dsl.support.GenericHandler;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Khaya.Mathebula on 04/01/2018.
 *
 */
@Configuration
public class IntegrationConfiguration {

    //Monitoring the following dir - ${HOME}/Desktop/data, and polling for new changes
    //if found will trigger and event.
    @Bean
    IntegrationFlow incomingFile(@Value("${HOME}/Desktop/drop")File dir){
        return IntegrationFlows.from(Files.inboundAdapter(dir)
            .preventDuplicates(true).autoCreateDirectory(true),
                poller -> poller.poller(spec -> spec.fixedRate(5, TimeUnit.SECONDS)))
                //now choose how to handle the data
                .handle(File.class, (payload, map) -> {
                    System.out.println("Retrieved a new file name: " + payload.getAbsolutePath());
                    return null;
                }).get();
    }
}
