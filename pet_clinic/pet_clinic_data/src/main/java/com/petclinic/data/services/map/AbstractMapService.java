package com.petclinic.data.services.map;

import javax.persistence.Id;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by khayapro on 2018/11/05.
 */

public abstract class AbstractMapService <T, ID> {

    Map<ID, T> map = new HashMap<>();

    T findById(final ID id) {
        return map.get(id);
    }

    void deletById(final ID id) {
        map.remove(id);
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T save(ID id, T object) {
        map.put(id, object);
        return map.get(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }



}
