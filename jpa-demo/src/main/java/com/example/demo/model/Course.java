package com.example.demo.model;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Basic(fetch = FetchType.EAGER)
    private String name;

    /**
     * Default constructor required by JPA
     */
    protected Course() {
        super();
    }

    public Course(final String name) {
        this.name = name;
    }

}
