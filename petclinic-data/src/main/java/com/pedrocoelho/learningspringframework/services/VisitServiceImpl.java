package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Visit;
import com.pedrocoelho.learningspringframework.repositories.VisitRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("jpa-services")
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findByDate(LocalDate date) {
        return visitRepository.findByDate(date);
    }

    @Override
    public Visit findByTime(LocalTime time) {
        return visitRepository.findByTime(time);
    }

    @Override
    public Visit findByDateAndTime(LocalDate date, LocalTime time) {
        Set<Visit> visits = visitRepository.findAllByDate(date);
        return visits.stream().filter(visit -> visit.getTime().equals(time)).findFirst().orElse(null);
    }

    @Override
    public Set<Visit> findAllByDate(LocalDate date) {
        return visitRepository.findAllByDate(date);
    }

    @Override
    public Visit findByPetName(String petName) {
        return visitRepository.findByPetName(petName);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit entity) {
        return visitRepository.save(entity);
    }

    @Override
    public Set<Visit> saveAll(List<Visit> entities) {
        Set<Visit> savedEntities = new HashSet<>();
        visitRepository.saveAll(entities).forEach(savedEntities::add);
        return savedEntities;
    }

    @Override
    public void delete(Visit entity) {
        visitRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
