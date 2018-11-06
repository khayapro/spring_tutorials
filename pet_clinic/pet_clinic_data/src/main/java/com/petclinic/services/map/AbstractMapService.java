package com.petclinic.services.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by khayapro on 2018/11/05.
 */

public abstract class AbstractMapService <T, ID>  {

    private final Map<ID, T> map;

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

    public T save(ID id, T object) {
        map.put(id, object);
        return map.get(id);
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

}
