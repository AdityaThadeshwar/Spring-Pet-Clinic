package com.adiya.springpetclinic.services.map;

import com.adiya.springpetclinic.model.BaseEntity;

import java.util.*;

//Added extends BaseEntity and Long so that generate ID function can work.
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    //Changed <ID, T> to <Long, T> so that getNextId function can work.
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    //Removed ID input parameter as we are auto-generating it
    T save(T object) {

        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    //Generate next IDs when object is created
    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}