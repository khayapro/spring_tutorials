package com.microservice.app.microserviceapp.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by khayapro on 2018/10/05.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomGeneratorServiceTest {

    @Autowired
    RandomGeneratorService generatorService;

    @Test
    public void generateRandomFactor() {
        final int responseA = generatorService.generateRandomFactor();
        assertThat(responseA).isNotEqualTo(0);
        final int responseB = generatorService.generateRandomFactor();
        assertThat(responseB).isNotEqualTo(100);
    }
}