package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
