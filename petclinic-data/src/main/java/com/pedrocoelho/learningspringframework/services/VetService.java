package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Vet;

import java.util.List;

public interface VetService extends CrudeService<Vet, Long> {
    List<Vet> findAllByFirstName(String firstName);

    List<Vet> findAllByLastName(String lastName);
}
