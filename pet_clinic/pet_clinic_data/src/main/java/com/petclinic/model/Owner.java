package com.petclinic.model;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by khayapro on 2018/10/31.
 */

@Data
@Entity
public class Owner extends Person {

    @OneToMany(mappedBy = "owner", targetEntity = Pet.class)
    private Set<Pet> pets = new HashSet<>();

    @Embedded
    private Contact contact;

}
