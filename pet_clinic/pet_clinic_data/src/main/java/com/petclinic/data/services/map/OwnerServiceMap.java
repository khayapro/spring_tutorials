package com.petclinic.data.services.map;

import com.petclinic.data.model.Owner;

/**
 * Created by khayapro on 2018/11/05.
 */

public class OwnerServiceMap extends AbstractMapService<Owner, Long> {

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

}
