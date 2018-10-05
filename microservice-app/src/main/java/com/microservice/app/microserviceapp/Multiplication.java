package com.microservice.app.microserviceapp;

import lombok.Data;

/**
 * Created by khayapro on 2018/10/05.
 */

@Data
public class Multiplication {

    private int factorA;
    private int factorB;
    private int result;

    public Multiplication(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
    }
}
