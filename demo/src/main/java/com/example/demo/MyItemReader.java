package com.example.demo;

import javax.batch.api.chunk.AbstractItemReader;
import javax.ejb.Stateful;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Named
@Stateful
public class MyItemReader extends AbstractItemReader {

    private static List<String> names;
    private static int count = 0;

    static {
        names = Arrays.asList("Khaya", "George", "Mike", "Tman", "Bro", "Kganya", "Thando", "Tumi", "Tshego", "Mandla");
    }

    @Override
    public String readItem() throws Exception {
        Thread.sleep(5000L);
        if (count < names.size()) {
            final String name = names.get(count);
            count++;
            return name;
        }
        return null;
    }
}
