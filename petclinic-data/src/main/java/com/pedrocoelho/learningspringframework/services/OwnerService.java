package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Owner;

import java.util.Set;

public interface OwnerService extends BaseService<Owner, Long> {
    Owner findByFirstName(String firstName);

    Owner findByLastName(String lastName);
}
