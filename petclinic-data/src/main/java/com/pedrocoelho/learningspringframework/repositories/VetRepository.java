package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VetRepository extends CrudRepository<Vet, Long> {
    List<Vet> findAllByLastName(String lastName);

    List<Vet> findAllByFirstName(String firstName);
}
