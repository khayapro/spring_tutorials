package com.microservice.app.microserviceapp;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by khayapro on 2018/10/23.
 */

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue
    private long id;
    private String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    Car() {
        super();
    }
}
