package com.pedrocoelho.learningspringframework.services;

import java.util.Set;

public interface BaseService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T entity);

//    Iterable<T> saveAll(Iterable<T> entities);

    void delete(T entity);

    void deleteById(ID id);
}
