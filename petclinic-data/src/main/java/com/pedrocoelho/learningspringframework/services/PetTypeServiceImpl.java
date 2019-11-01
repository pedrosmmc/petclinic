package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.PetType;
import com.pedrocoelho.learningspringframework.repositories.PetTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("jpa-services")
public class PetTypeServiceImpl implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
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
    public Set<PetType> saveAll(List<PetType> entities) {
        Set<PetType> savedEnities = new HashSet<>();
        petTypeRepository.saveAll(entities).forEach(savedEnities::add);
        return savedEnities;
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
