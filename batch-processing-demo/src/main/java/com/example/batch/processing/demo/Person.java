package com.example.batch.processing.demo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_name")
    private String name;
    @Column(name = "c_surname")
    private String surname;
    @Column(name = "c_age")
    private int age;
}
