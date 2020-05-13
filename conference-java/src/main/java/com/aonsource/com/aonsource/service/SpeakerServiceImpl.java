package com.aonsource.com.aonsource.service;

import com.aonsource.model.Speaker;
import com.aonsource.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository;

    @Autowired
    public SpeakerServiceImpl(final SpeakerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }
}
