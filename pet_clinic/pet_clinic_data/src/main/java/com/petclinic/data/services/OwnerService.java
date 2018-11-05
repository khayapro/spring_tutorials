package com.petclinic.data.services;

import com.petclinic.data.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by khayapro on 2018/11/01.
 */

public interface OwnerService extends CrudRepository<Owner, Long>{

    Owner findOwnerBySurname(String surname);
}
