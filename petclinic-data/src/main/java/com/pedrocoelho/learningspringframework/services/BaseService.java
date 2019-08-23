package com.pedrocoelho.learningspringframework.services;

import java.util.Optional;
import java.util.Set;

public interface BaseService<T, Long> {
    Set<T> findAll();

    T findById(Long id);

    T save(T object);

    Iterable<T> saveAll(Iterable<T> entities);

    void delete(T object);
}
