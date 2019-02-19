package com.petclinic.model;

import lombok.Data;

import java.util.Set;

/**
 * Created by khayapro on 2018/10/31.
 */

@Data
public class Vet extends Person {

    private Set<Speciality> specialities;

}
