package com.microservice.app.microserviceapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by khayapro on 2018/10/23.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Iterable<Car> findCarByMake(String make);
}
