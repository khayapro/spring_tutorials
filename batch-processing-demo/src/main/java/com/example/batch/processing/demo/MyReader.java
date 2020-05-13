package com.example.batch.processing.demo;

import javax.batch.api.AbstractBatchlet;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Dependent
@Named
public class MyReader extends AbstractBatchlet {

    @Inject
    private Repository repository;

    @Override
    public String process() throws Exception {

        final ConcurrentMap<Integer, List<String>> map = new ConcurrentHashMap<>();
        System.out.println("********* batch processed ********* ");
        final Person person = new Person();
        person.setAge(35);
        person.setName("Khaya");
        person.setSurname("Mathebula");
        repository.save(person);
        return "COMPLETED";
    }
}
