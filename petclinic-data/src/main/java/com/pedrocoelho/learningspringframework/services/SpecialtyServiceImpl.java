package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Specialty;
import com.pedrocoelho.learningspringframework.repositories.SpecialtyRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("jpa-services")
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository SpecialtyRepository;

    public SpecialtyServiceImpl(SpecialtyRepository SpecialtyRepository) {
        this.SpecialtyRepository = SpecialtyRepository;
    }

    @Override
    public Specialty findByName(String denomination) {
        return SpecialtyRepository.findByDenomination(denomination);
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialities = new HashSet<>();
        SpecialtyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Specialty findById(Long id) {
        return SpecialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty entity) {
        return SpecialtyRepository.save(entity);
    }

    @Override
    public Set<Specialty> saveAll(List<Specialty> entities) {
        Set<Specialty> savedEntities = new HashSet<>();
        SpecialtyRepository.saveAll(entities).forEach(savedEntities::add);
        return savedEntities;
    }

    @Override
    public void delete(Specialty entity) {
        SpecialtyRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        SpecialtyRepository.deleteById(id);
    }
}
