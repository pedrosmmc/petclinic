package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface VetRepository extends CrudRepository<Vet, Long> {
    List<Vet> findAllByFirstName(String firstName);

    List<Vet> findAllByLastName(String lastName);

    Optional<Vet> findByFirstName(String firstName);

    Optional<Vet> findByLastName(String lastName);
}
