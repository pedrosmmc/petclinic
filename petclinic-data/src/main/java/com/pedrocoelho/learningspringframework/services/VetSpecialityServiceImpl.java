package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Speciality;
import com.pedrocoelho.learningspringframework.repositories.VetSpecialityRepository;

import java.util.HashSet;
import java.util.Set;

public class VetSpecialityServiceImpl implements VetSpecialityService {

    private final VetSpecialityRepository vetSpecialityRepository;

    public VetSpecialityServiceImpl(VetSpecialityRepository vetSpecialityRepository) {
        this.vetSpecialityRepository = vetSpecialityRepository;
    }

    @Override
    public Speciality findByName(String denomination) {
        return vetSpecialityRepository.findByName(denomination);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        vetSpecialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return vetSpecialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality entity) {
        return vetSpecialityRepository.save(entity);
    }

    @Override
    public void delete(Speciality entity) {
        vetSpecialityRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        vetSpecialityRepository.deleteById(id);
    }
}
