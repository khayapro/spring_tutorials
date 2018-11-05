package com.petclinic.data.services;

import java.util.Set;

/**
 * Created by khayapro on 2018/11/05.
 */

public interface CrudService <T, ID> {

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

    Set<T> findAll();

}
