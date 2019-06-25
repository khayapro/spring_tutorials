package com.example.filesintegration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.transformer.GenericTransformer;

import java.io.File;

@SpringBootApplication
public class FilesIntegrationApplication {


    //integration flow, looks for data in a directory
    @Bean
    IntegrationFlow file(@Value("${input-directory:${HOME}/Desktop/in}") File inputDir) {
        return IntegrationFlows.from(Files.inboundAdapter(inputDir).autoCreateDirectory(true).preventDuplicates())
                .transform(File.class, (GenericTransformer<File, String>) file -> {
                    return null;
                }).handle()

    }

    public static void main(String[] args) {
        SpringApplication.run(FilesIntegrationApplication.class, args);
    }

}
