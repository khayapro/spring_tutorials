/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.demo;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;

@Named
@Stateless
public class MyItemWriter extends AbstractItemWriter {

    @Override
    public void writeItems(List<Object> list) throws Exception {
        if (list != null && !list.isEmpty()) {
            System.out.println("chuck size: " + list.size());

            //Todo: persist the chunk to DB
            list.forEach(p -> {
                final Person person = (Person) p;
                System.out.println("persist person object: " + person.getName());
            });
        }
    }
}
