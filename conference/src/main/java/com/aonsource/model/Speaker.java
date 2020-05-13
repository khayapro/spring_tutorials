package com.aonsource.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Speaker {

    private String firstName;
    private String lastName;
}
