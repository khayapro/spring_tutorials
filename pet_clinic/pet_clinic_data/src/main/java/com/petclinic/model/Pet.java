package com.petclinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * Created by khayapro on 2018/10/31.
 */

@Data
@Entity
public class Pet extends BaseEntity {

    private String petType;
    @JoinColumn(name = "owner_id", nullable = false)
    @ManyToOne
    private Owner owner;
    private LocalDate birthDate;

}
