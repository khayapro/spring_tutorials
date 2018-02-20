package com.example.events.repository;

import com.example.events.events.DomainEvent;
import com.example.events.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class EventSourceUserRepository implements UserRepository {

    private final Map<UUID, List<DomainEvent>> users = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        List<DomainEvent> newChanges = user.getChanges();
        List<DomainEvent> currentChanges = users.getOrDefault(user.getId(), new ArrayList<>());
        currentChanges.addAll(newChanges);
        users.put(user.getId(), currentChanges);
        user.flushChanges();

    }

    @Override
    public User find(UUID id) {
        if(!users.containsKey(id))
            return null;


        return null;
    }
}
