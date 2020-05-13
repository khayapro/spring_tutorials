/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.demo;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

@Named(value = "BatchComplete2")
public class BatchComplete2 extends AbstractBatchlet {

    @Inject
    private JobContext context;

    @Override
    public String process() {
        System.out.println("shutting down.....");
        final ExecutorService executorService = (ExecutorService) context.getTransientUserData();
        executorService.shutdown();
        System.out.println("shutting down completed.....");
        return "COMPLETED";
    }


}
