package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Pet;

import java.util.List;

public interface PetService extends BaseService<Pet, Long> {
    List<Pet> findAllByName(String name);
}
