package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    /**
     * Default constructor required by JPA
     */
    public Course() {
        super();
    }

    public Course(final String name) {
        this.name = name;
    }

}
