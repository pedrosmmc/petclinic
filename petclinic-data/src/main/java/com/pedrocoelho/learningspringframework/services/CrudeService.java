package com.pedrocoelho.learningspringframework.services;

import java.util.List;
import java.util.Set;

public interface CrudeService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T entity);

    Set<T> saveAll(List<T> entities);

    void delete(T entity);

    void deleteById(ID id);
}
