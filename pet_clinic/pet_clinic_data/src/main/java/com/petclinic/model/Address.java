package com.petclinic.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String suburb;
    private String city;
    private String postalCode;
}
