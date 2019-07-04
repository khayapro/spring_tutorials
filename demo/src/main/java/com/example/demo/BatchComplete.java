/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.demo;

import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Named(value = "BatchComplete")
public class BatchComplete extends AbstractBatchlet {



    private BlockingQueue queue = new ArrayBlockingQueue<String>(10);

    @Override
    public String process() throws Exception {
        System.out.println("completed batch process.....");
        return "COMPLETED";
    }


}
