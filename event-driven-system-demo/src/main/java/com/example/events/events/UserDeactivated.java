package com.example.events.events;

import java.time.Instant;

public class UserDeactivated implements DomainEvent {
    private Instant when;

    public UserDeactivated(Instant when) {
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
