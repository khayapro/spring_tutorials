package com.petclinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by khayapro on 2018/10/31.
 */

@Data
@Entity
public class Vet extends Person {

    @OneToMany
    private Set<Speciality> specialities;

}
