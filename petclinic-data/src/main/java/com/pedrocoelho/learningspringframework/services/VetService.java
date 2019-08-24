package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Vet;

import java.util.List;
import java.util.Set;

public interface VetService extends BaseService<Vet, Long> {
    List<Vet> findAllByFirstName(String firstName);

    List<Vet> findAllByLastName(String lastName);
}
