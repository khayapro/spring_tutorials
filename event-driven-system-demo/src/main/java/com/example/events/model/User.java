package com.example.events.model;

import com.example.events.events.DomainEvent;
import com.example.events.events.UserActivated;
import com.example.events.events.UserDeactivated;
import com.example.events.events.UserNameChange;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class User {


    public void flushChanges() {
        this.changes.clear();
    }

    enum UserState { ACTIVATED, DEACTIVATED }

    private UUID id;
    private String name;
    private UserState state;
    private List<DomainEvent> changes = new ArrayList<>();


    public User(UUID id) {
        this.id = id;
    }


    public UUID getId() {
        return id;
    }

    public void activate(){
        if(isActivated())
            throw new IllegalArgumentException("User already activated.");
        userActivated(new UserActivated(Instant.now()));
    }

    private void userActivated(UserActivated activated) {
        this.state = UserState.ACTIVATED;
        changes.add(activated);
    }

    public void deactivate(){
        if(isDeactivated())
            throw new IllegalArgumentException("User already deactivated.");
        //event
        userDeactivated(new UserDeactivated(Instant.now()));
    }

    private void userDeactivated(UserDeactivated deactivated) {
        this.state = UserState.DEACTIVATED;
        changes.add(deactivated);
    }

    public boolean isActivated(){
        return this.state == UserState.ACTIVATED;
    }

    public boolean isDeactivated(){
        return this.state == UserState.DEACTIVATED;
    }


    public void changeName(final String newName){
        if(isDeactivated())
            throw new IllegalArgumentException("Cannot change name, user deactivated.");
        userNameChanged(new UserNameChange(newName, Instant.now()));
    }

    private void userNameChanged(UserNameChange userNameChange) {
        this.name = userNameChange.getNewName();
        changes.add(userNameChange);
    }

    public String getName(){
        return name;
    }

    public List<DomainEvent> getChanges() {
        return Collections.unmodifiableList(changes);
    }

}
