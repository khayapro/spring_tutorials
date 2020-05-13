package com.aonsource.repository;

import com.aonsource.model.Speaker;

import java.util.Collections;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {


    @Override
    public List<Speaker> findAll() {
        return Collections.singletonList(Speaker.builder()
                .firstName("Kganya")
                .lastName("Mathebula")
                .build());
    }
}
