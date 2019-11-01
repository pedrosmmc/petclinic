package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Pet;
import com.pedrocoelho.learningspringframework.repositories.PetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("jpa-services")
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAllByName(String name) {
        return new HashSet<>(petRepository.findAllByName(name));
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet entity) {
        return petRepository.save(entity);
    }

    @Override
    public Set<Pet> saveAll(List<Pet> entities) {
        Set<Pet> savedEntities = new HashSet<>();
        petRepository.saveAll(entities).forEach(savedEntities::add);
        return savedEntities;
    }

    @Override
    public void delete(Pet entity) {
        petRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
