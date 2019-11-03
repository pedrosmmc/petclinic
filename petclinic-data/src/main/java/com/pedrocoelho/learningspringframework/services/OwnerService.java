package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Owner;

import java.util.List;

public interface OwnerService extends CrudeService<Owner, Long> {
    List<Owner> findAllByFirstName(String firstName);

    Owner findByFirstName(String firstName);

    List<Owner> findAllByLastName(String lastName);

    Owner findByLastName(String lastName);
}
