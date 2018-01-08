package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.integration.launch.JobLaunchRequest;
import org.springframework.batch.integration.launch.JobLaunchingGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.file.Files;
import org.springframework.integration.dsl.support.GenericHandler;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.util.List;
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
    IntegrationFlow incomingFile(@Value("${HOME}/Desktop/drop")File dir, JobLauncher launcher, Job job, JdbcTemplate template){
        return IntegrationFlows.from(Files.inboundAdapter(dir).preventDuplicates(true).autoCreateDirectory(true),
            poller -> poller.poller(spec -> spec.fixedRate(5, TimeUnit.SECONDS)))
            //1. First Transform the data into a JobLaunchRequest
            .transform((GenericTransformer<File, JobLaunchRequest>) file -> {
                JobParameters jobParameters = new JobParametersBuilder().addString("file", file.getAbsolutePath()).toJobParameters();
                return new JobLaunchRequest(job, jobParameters);
            })
            //2. Hand over the JoblaunchRequest to JobLaunchGateway
            .handle(new JobLaunchingGateway(launcher))
            .handle(JobExecution.class, (jobExecution, map) -> {
                System.out.println("execution status: " + jobExecution.getExitStatus());
                List<Person> personList = template.query("select * from PEOPLE", (rs, i)
                        -> new Person(rs.getString("name"), rs.getString("surname"),
                        rs.getString("email")));
                personList.forEach(System.out::println);
                return null;
            }).get();
    }
}


