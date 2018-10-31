package com.petclinic.data.model;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by khayapro on 2018/10/31.
 */
@Data
public class Pet {

    private PetType type;
    private Owner owner;
    private LocalDate birthDate;

}
