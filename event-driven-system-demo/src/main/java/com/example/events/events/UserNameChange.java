package com.example.events.events;

import java.time.Instant;

public class UserNameChange implements DomainEvent {
    private final String newName;
    private final Instant when;

    public UserNameChange(String newName, Instant when) {
        this.newName = newName;
        this.when = when;
    }

    public String getNewName() {
        return newName;
    }


    @Override
    public Instant occuredAt() {
        return when;
    }
}
