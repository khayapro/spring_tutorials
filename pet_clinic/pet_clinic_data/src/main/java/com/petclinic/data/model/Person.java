package com.petclinic.data.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

/**
 * Created by khayapro on 2018/10/31.
 */

@Data
@MappedSuperclass
public class Person extends BaseEntity {

    private String name;
    private String surname;
}
