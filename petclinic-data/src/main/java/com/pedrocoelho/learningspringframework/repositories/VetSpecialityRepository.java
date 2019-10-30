package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface VetSpecialityRepository extends CrudRepository<Speciality, Long> {
    Speciality findByName(String name);
}
