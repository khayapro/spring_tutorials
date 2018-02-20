package com.example.events.events;

import java.time.Instant;

public interface DomainEvent {

    Instant occuredAt();
}
