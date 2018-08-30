package com.example.spring5webapp.model;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @Embedded
    private Address address;

    protected Publisher() {
        super();
    }

    public Publisher(final String name, final Address address){
        this.name = name;
        this.address = address;
    }
}
