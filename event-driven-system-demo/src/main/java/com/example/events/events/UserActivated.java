package com.example.events.events;

import java.time.Instant;

public class UserActivated implements DomainEvent {
    private final Instant when;

    public UserActivated(Instant when) {
        this.when = when;
    }

    public Instant getWhen() {
        return when;
    }


    @Override
    public Instant occuredAt() {
        return when;
    }
}
