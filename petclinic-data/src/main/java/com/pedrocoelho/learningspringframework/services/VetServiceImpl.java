package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Vet;
import com.pedrocoelho.learningspringframework.repositories.SpecialtyRepository;
import com.pedrocoelho.learningspringframework.repositories.VetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("jpa-services")
public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;
    private final SpecialtyRepository SpecialtyRepository;

    public VetServiceImpl(VetRepository vetRepository, SpecialtyRepository SpecialtyRepository) {
        this.vetRepository = vetRepository;
        this.SpecialtyRepository = SpecialtyRepository;
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
    public Vet findByFirstName(String firstName) {
        return vetRepository.findByFirstName(firstName).orElse(null);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return vetRepository.findByFirstName(lastName).orElse(null);
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
    public Set<Vet> saveAll(List<Vet> entities) {
        Set<Vet> savedEntities = new HashSet<>();
        vetRepository.saveAll(entities).forEach(savedEntities::add);
        return savedEntities;
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
