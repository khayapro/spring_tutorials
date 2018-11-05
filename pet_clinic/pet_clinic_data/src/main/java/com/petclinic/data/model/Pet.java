package com.petclinic.data.model;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Created by khayapro on 2018/10/31.
 */
@Data
@Entity
public class Pet extends BaseEntity {

    private PetType type;
    private Owner owner;
    private LocalDate birthDate;

}
