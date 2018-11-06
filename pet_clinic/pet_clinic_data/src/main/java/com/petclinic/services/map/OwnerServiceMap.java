package com.petclinic.services.map;

import com.petclinic.model.Owner;
import com.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

/**
 * Created by khayapro on 2018/11/05.
 */
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findOwnerBySurname(String surname) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }
}
