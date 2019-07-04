package com.example.batch.processing.demo;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import java.util.Properties;

@Singleton
public class SingletonBean {

    @Schedule(hour = "21", minute = "33")
    public void start() {
        System.out.println("********** timer started *********");
        final JobOperator jobOperator = BatchRuntime.getJobOperator();
        jobOperator.start("job", new Properties());
    }
}
