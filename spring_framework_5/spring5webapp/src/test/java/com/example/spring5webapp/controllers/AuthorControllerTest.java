package com.example.spring5webapp.controllers;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class AuthorControllerTest {

    @Test
    public void getAuthors() {
        final String id = UUID.randomUUID().toString();
        final String encoded = Base64.encodeBase64String(id.getBytes());
        System.out.println("UUID: " + encoded);
        System.out.println("UUID: " + Base64.decodeBase64(encoded.getBytes()));
    }
}