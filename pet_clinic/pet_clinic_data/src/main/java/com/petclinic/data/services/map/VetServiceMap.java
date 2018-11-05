package com.petclinic.data.services.map;

import com.petclinic.data.model.Vet;

/**
 * Created by khayapro on 2018/11/05.
 */

public class VetServiceMap extends AbstractMapService<Vet, Long> {

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }
}