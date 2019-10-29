package com.pedrocoelho.learningspringframework.services.dao;

import com.pedrocoelho.learningspringframework.model.Vet;
import com.pedrocoelho.learningspringframework.repositories.SpecialityRepository;
import com.pedrocoelho.learningspringframework.repositories.VetRepository;
import com.pedrocoelho.learningspringframework.services.VetService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class VetDao implements VetService {

    private final VetRepository vetRepository;
    private final SpecialityRepository specialityRepository;

    public VetDao(VetRepository vetRepository, SpecialityRepository specialityRepository) {
        this.vetRepository = vetRepository;
        this.specialityRepository = specialityRepository;
    }

    @Override
    public List<Vet> findAllByFirstName(String firstName) {
        return vetRepository.findAllByFirstName(firstName);
    }

    @Override
    public List<Vet> findAllByLastName(String lastName) {
        return vetRepository.findAllByLastName(lastName);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet entity) {
        return vetRepository.save(entity);
    }

    @Override
    public void delete(Vet entity) {
        vetRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
