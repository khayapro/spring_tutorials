package com.aonsource.repository;

import com.aonsource.model.Speaker;

import java.util.List;

public interface SpeakerRepository {

    List<Speaker> findAll();
}
