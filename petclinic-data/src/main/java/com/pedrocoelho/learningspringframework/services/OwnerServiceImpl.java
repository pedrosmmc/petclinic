package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Owner;
import com.pedrocoelho.learningspringframework.repositories.OwnerRepository;
import com.pedrocoelho.learningspringframework.repositories.PetRepository;
import com.pedrocoelho.learningspringframework.repositories.PetTypeRepository;
import com.pedrocoelho.learningspringframework.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("jpa-services")
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public List<Owner> findAllByFirstName(String firstName) {
        return ownerRepository.findAllByFirstName(firstName);
    }

    @Override
    public List<Owner> findAllByLastName(String lastName) {
        return ownerRepository.findAllByLastName(lastName);
    }

    @Override
    public Owner findByFirstName(String firstName) {
        return ownerRepository.findByFirstName(firstName);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner entity) {
        return ownerRepository.save(entity);
    }

    @Override
    public Set<Owner> saveAll(List<Owner> entities) {
        Set<Owner> savedEntities = new HashSet<>();
        ownerRepository.saveAll(entities).forEach(savedEntities::add);
        return savedEntities;
    }

    @Override
    public void delete(Owner entity) {
        ownerRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
