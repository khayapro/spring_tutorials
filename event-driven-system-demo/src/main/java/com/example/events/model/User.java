package com.example.events.model;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private boolean activated;

    public User(UUID id) {
        this.id = id;
    }

    void activate(){
        this.activated = true;
    }

    void deactivate(){
        this.activated = false;
    }

    boolean isActivated(){
        return activated;
    }

    boolean isDeactivated(){
        return !activated;
    }


    void changeName(final String newName){
        if(isDeactivated())
            throw new IllegalArgumentException();

        this.name = newName;
    }

    String getName(){
        return name;
    }






}
