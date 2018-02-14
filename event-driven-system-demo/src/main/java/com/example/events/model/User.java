package com.example.events.model;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private UserState state;

    enum UserState { ACTIVATED, DEACTIVATED }

    public User(UUID id) {
        this.id = id;
    }

    void activate(){
        if(isActivated())
            throw new IllegalArgumentException("User already activated.");
        this.state = UserState.ACTIVATED;
    }

    void deactivate(){
        if(isDeactivated())
            throw new IllegalArgumentException("User already deactivated.");
        this.state = UserState.DEACTIVATED;
    }

    boolean isActivated(){
        return this.state == UserState.ACTIVATED;
    }

    boolean isDeactivated(){
        return this.state == UserState.DEACTIVATED;
    }


    void changeName(final String newName){
        if(isDeactivated())
            throw new IllegalArgumentException("Cannot change name, user deactivated.");
        this.name = newName;
    }

    String getName(){
        return name;
    }

}
