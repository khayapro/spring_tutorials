package com.example.batch.processing.demo;

import javax.batch.api.AbstractBatchlet;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named
public class MyReader extends AbstractBatchlet {

    @Inject
    private Repository repository;

    @Override
    public String process() throws Exception {
        System.out.println("********* batch processed ********* ");
        final Person person = new Person();
        person.setAge(35);
        person.setName("Khaya");
        person.setSurname("Mathebula");
        repository.save(person);
        return "COMPLETED";
    }
}
