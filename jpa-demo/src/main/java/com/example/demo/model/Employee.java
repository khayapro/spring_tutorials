package com.example.demo.model;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Data
@Entity
@Table(name = "employee")
public class Employee extends Course {

    @Id
    @TableGenerator(name = "EMP_GEN", table = "EMP_GEN_ID", pkColumnName = "PK_GEN_NAME", valueColumnName = "PK_GEN_VAL")
    @GeneratedValue(generator = "EMP_GEN")
    private Long id;
    @Basic
    private String name;
    private Double salary;

    private transient String translatedName;
}
