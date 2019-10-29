package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
    PetType findByName(String name);
}
