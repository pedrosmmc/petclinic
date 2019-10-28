package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
