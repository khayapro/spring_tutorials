package com.aonsource.repository;

import com.aonsource.model.Speaker;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SpeakerRepository {

    List<Speaker> findAll();
}
