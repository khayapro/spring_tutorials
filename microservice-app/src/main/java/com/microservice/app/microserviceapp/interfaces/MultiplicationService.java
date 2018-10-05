package com.microservice.app.microserviceapp.interfaces;

import com.microservice.app.microserviceapp.Multiplication;

/**
 * Created by khayapro on 2018/10/05.
 */

public interface MultiplicationService {

    /**
     * Create random multiplication with two factors
     * @return Multiplication
     */
    Multiplication createRandomMultiplication();

}
