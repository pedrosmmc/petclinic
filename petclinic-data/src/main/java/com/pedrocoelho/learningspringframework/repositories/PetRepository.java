package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
