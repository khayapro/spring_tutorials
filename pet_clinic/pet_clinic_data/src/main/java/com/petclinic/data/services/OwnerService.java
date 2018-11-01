package com.petclinic.data.services;

import com.petclinic.data.model.Owner;

import java.util.Set;

/**
 * Created by khayapro on 2018/11/01.
 */

public interface OwnerService {

    Owner findById(final Long id);

    Owner save(final Owner owner);

    Set<Owner> saveAll(final Set<Owner> owners);

    Set<Owner> findAll();

}
