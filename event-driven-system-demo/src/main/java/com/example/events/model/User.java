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

    public void activate(){
        if(isActivated())
            throw new IllegalArgumentException("User already activated.");
        this.state = UserState.ACTIVATED;
    }

    public void deactivate(){
        if(isDeactivated())
            throw new IllegalArgumentException("User already deactivated.");
        this.state = UserState.DEACTIVATED;
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
        this.name = newName;
    }

    public String getName(){
        return name;
    }

}
