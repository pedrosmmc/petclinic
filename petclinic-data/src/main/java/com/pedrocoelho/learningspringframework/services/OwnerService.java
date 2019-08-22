package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Owner;

import java.util.Set;

public interface OwnerService  {
    Owner findByFirstName(String firstName);
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
