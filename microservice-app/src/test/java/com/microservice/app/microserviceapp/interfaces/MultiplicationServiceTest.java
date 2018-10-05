package com.microservice.app.microserviceapp.interfaces;

import com.microservice.app.microserviceapp.Multiplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by khayapro on 2018/10/05.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

    @MockBean
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    private MultiplicationService multiplicationService;


    @Test
    public void createRandomMultiplication() {
        given(randomGeneratorService.generateRandomFactor()).willReturn(10, 50);

        final Multiplication response = multiplicationService.createRandomMultiplication();
        assertThat(response.getFactorA()).isEqualTo(10);
        assertThat(response.getFactorB()).isEqualTo(50);
        assertThat(response.getResult()).isEqualTo(500);
    }
}