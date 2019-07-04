package com.example.batch.processing.demo;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @Inject
    private SingletonBean bean;

    @GET
    public String sayHello() {
        bean.start();
        return "Hello World";
    }
}
