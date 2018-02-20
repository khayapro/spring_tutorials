package com.example.events.repository;

import com.example.events.model.User;

import java.util.UUID;

public interface UserRepository {

    void save(User user);
    User find(UUID id);
}
