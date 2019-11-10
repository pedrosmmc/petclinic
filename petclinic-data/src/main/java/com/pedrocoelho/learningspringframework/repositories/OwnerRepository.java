package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Set<Owner> findAllByFirstName(String firstName);

    Set<Owner> findAllByLastName(String lastName);

    Optional<Owner> findByFirstName(String firstName);

    Optional<Owner> findByLastName(String lastName);
}
