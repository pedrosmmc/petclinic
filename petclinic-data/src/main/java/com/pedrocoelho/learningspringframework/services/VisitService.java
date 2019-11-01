package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Visit;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public interface VisitService extends CrudeService<Visit, Long> {
    Visit findByDate(LocalDate date);

    Visit findByTime(LocalTime time);

    Visit findByDateAndTime(LocalDate date, LocalTime time);

    Visit findByPetName(String petName);

    Set<Visit> findAllByDate(LocalDate date);
}
