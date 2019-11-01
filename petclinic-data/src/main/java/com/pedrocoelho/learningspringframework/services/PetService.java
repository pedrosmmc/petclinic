package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Pet;

import java.util.Set;


public interface PetService extends CrudeService<Pet, Long> {
    Set<Pet> findAllByName(String name);
}
