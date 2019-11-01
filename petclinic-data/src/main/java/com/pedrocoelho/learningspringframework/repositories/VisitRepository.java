package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.Visit;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public interface VisitRepository extends CrudRepository<Visit, Long> {

    Visit findByDate(LocalDate date);

    Visit findByTime(LocalTime time);

    Set<Visit> findAllByDate(LocalDate date);

    Visit findByPetName(String petName);
}
