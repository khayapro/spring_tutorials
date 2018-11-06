package com.petclinic.services;

import com.petclinic.model.Owner;

/**
 * Created by khayapro on 2018/11/01.
 */

public interface OwnerService extends  CrudService<Owner, Long> {

    Owner findOwnerBySurname(String surname);
}
