package com.example.spring5webapp.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    private String streetName;
    private String suburb;
    private String city;
    private int postalCode;

    public Address() {
        super();
    }
}
