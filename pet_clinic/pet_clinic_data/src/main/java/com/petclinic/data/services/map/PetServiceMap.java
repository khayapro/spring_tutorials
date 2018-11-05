package com.petclinic.data.services.map;

import com.petclinic.data.model.Pet;

/**
 * Created by khayapro on 2018/11/05.
 */

public class PetServiceMap extends AbstractMapService<Pet, Long> {
    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }
}
