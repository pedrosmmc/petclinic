package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends BaseService<Owner, Long> {
    List<Owner> findAllByFirstName(String firstName);

    List<Owner> findAllByLastName(String lastName);
}
