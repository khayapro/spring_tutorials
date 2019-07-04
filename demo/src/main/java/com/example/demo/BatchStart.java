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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Stateless
public class BatchStart {

    private AtomicInteger count = new AtomicInteger();
    final JobOperator jo = BatchRuntime.getJobOperator();

    @Schedule(second = "*", info = "Runs every 10 seconds")
    public void startBatchProcess() {

        final ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
        schedule.schedule(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("This is running...: count: " + count);
                    count.incrementAndGet();
                    try {
                        Thread.sleep(2000);
                        if (count.get() == 10) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },2, TimeUnit.SECONDS);
        start();
    }

    public void start() {
        final long jobId = jo.start("job1", new Properties());
        System.out.println("STARTED JOB1 - ID: " + jobId);
    }
}
