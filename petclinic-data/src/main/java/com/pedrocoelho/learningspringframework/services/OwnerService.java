package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudeService<Owner, Long> {
    Set<Owner> findAllByFirstName(String firstName);

    Owner findByFirstName(String firstName);

    Set<Owner> findAllByLastName(String lastName);

    Owner findByLastName(String lastName);
}
