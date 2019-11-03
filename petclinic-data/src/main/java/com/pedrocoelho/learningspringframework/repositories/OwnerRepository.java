package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    List<Owner> findAllByFirstName(String firstName);

    List<Owner> findAllByLastName(String lastName);

    Owner findByFirstName(String firstName);

    Owner findByLastName(String lastName);
}
