package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
