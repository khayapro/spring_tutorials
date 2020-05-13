package com.aonsource.com.aonsource.service;

import com.aonsource.model.Speaker;
import com.aonsource.repository.HibernateSpeakerRepositoryImpl;
import com.aonsource.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }



}
