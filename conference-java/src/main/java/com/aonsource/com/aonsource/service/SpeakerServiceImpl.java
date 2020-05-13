package com.aonsource.com.aonsource.service;

import com.aonsource.model.Speaker;
import com.aonsource.repository.SpeakerRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Setter
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerRepository repository;

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

}
