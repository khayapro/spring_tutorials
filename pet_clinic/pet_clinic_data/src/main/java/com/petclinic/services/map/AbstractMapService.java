package com.petclinic.services.map;

import com.petclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by khayapro on 2018/11/05.
 */

public abstract class AbstractMapService <T extends BaseEntity, ID extends Long>  {

    private final Map<Long, T> map;

    protected AbstractMapService() {
        map = new HashMap<>();
    }

    public T findById(final ID id) {
        return map.get(id);
    }

    public void deleteById(ID id) {
        Optional.of(map.get(id)).ifPresent(map::remove);
    }

    public Set<T> findAll() {
        return map.values().stream().collect(Collectors.toSet());
    }

    public T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(generateNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new IllegalArgumentException("Cannot save null value object");
        }

        return map.get(object.getId());
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long generateNextId() {
        Long nextId;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }


}
