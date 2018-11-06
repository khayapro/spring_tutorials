package com.petclinic.data.services.map;

import com.petclinic.data.model.Owner;
import com.petclinic.data.services.OwnerService;

/**
 * Created by khayapro on 2018/11/05.
 */

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findOwnerBySurname(String surname) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }
}
