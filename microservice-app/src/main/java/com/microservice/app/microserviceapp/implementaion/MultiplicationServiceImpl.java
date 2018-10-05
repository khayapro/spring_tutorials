package com.microservice.app.microserviceapp.implementaion;

import com.microservice.app.microserviceapp.Multiplication;
import com.microservice.app.microserviceapp.interfaces.MultiplicationService;
import com.microservice.app.microserviceapp.interfaces.RandomGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by khayapro on 2018/10/05.
 */

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;

    @Autowired
    public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        return new Multiplication(randomGeneratorService.generateRandomFactor(), randomGeneratorService.generateRandomFactor());
    }
}
