package com.petclinic.services.map;

import com.petclinic.model.Pet;
import com.petclinic.services.PetService;
import org.springframework.stereotype.Service;

/**
 * Created by khayapro on 2018/11/05.
 */
@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
