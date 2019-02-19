package com.petclinic.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class Visit extends BaseEntity {


    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "dd-MM-yyy")
    private LocalDate date;
    private String description;
    private Pet pet;


}
