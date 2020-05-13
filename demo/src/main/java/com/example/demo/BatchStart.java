/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.demo;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import java.util.Properties;

@Stateless
public class BatchStart {

    final JobOperator jo = BatchRuntime.getJobOperator();

    @Schedule(hour = "21", minute = "31", info = "Runs every 10 seconds")
    public void startBatchProcess() {
        start();
    }

    public void start() {
        final long jobId = jo.start("job1", new Properties());
        System.out.println("STARTED JOB1 - ID: " + jobId);
    }
}
