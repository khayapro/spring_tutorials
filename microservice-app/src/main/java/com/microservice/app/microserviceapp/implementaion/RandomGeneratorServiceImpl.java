package com.microservice.app.microserviceapp.implementaion;

import com.microservice.app.microserviceapp.interfaces.RandomGeneratorService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by khayapro on 2018/10/05.
 */
@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService {

    @Override
    public int generateRandomFactor() {
        return new Random().nextInt(100) + 1;
    }
}
