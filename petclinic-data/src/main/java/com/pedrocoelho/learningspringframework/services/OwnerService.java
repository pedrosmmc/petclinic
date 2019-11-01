package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OwnerService extends CrudeService<Owner, Long> {
    List<Owner> findAllByFirstName(String firstName);

    List<Owner> findAllByLastName(String lastName);
}
