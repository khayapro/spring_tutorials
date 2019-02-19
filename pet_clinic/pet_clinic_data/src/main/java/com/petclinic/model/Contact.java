package com.petclinic.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Contact {

    @Embedded
    private Address address;

    private String telephone;
    private String cellPhone;
}
