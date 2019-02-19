package com.petclinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import java.util.Set;

/**
 * Created by khayapro on 2018/10/31.
 */

@Data
@Entity
public class Owner extends Person {

    private Set<Pet> pets;

}
