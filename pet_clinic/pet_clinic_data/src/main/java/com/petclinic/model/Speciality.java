package com.petclinic.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Speciality  extends  BaseEntity {

    private String description;

}
