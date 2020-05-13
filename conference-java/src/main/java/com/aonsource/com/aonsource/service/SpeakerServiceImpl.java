package com.aonsource.com.aonsource.service;

import com.aonsource.model.Speaker;
import com.aonsource.repository.SpeakerRepository;
import lombok.Setter;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository;

    public SpeakerServiceImpl(final SpeakerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

}
