package com.example.demo;

import javax.batch.api.chunk.ItemProcessor;
import javax.ejb.Stateless;
import javax.inject.Named;

@Named(value = "MyItemProcessor")
//@Stateless
public class MyItemProcessor implements ItemProcessor {

    @Override
    public Person processItem(Object o) {
        if (o != null) {
            final String value = (String) o;
            return new Person(value);
        }
        return null;
    }
}
