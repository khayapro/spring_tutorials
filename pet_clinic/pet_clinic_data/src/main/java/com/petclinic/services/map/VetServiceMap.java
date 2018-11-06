package com.petclinic.services.map;

import com.petclinic.model.Vet;
import com.petclinic.services.VetService;
import org.springframework.stereotype.Service;

/**
 * Created by khayapro on 2018/11/05.
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }
}
