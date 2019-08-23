package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Vet;

import java.util.Set;

public interface VetService extends BaseService<Vet, Long> {
    Vet findByFirstName(String firstName);

    Vet findByLastName(String lastName);
}
