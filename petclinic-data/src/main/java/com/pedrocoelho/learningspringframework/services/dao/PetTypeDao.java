package com.pedrocoelho.learningspringframework.services.dao;

import com.pedrocoelho.learningspringframework.model.PetType;
import com.pedrocoelho.learningspringframework.repositories.PetTypeRepository;
import com.pedrocoelho.learningspringframework.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

public class PetTypeDao implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeDao(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findByName(String name) {
        return petTypeRepository.findByName(name);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType entity) {
        return petTypeRepository.save(entity);
    }

    @Override
    public void delete(PetType entity) {
        petTypeRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
