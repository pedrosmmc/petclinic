package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.Specialty;
import com.pedrocoelho.learningspringframework.model.Vet;
import com.pedrocoelho.learningspringframework.services.VetService;
import com.pedrocoelho.learningspringframework.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile("map-services")
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private SpecialtyService vetSpecialtyService;

    public VetMapService(SpecialtyService vetSpecialtyService) {
        this.vetSpecialtyService = vetSpecialtyService;
    }

    @Override
    public List<Vet> findAllByFirstName(String firstName) {
        return map.values().stream().filter(vet -> vet.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vet> findAllByLastName(String lastName) {
        return map
                .values()
                .stream()
                .filter(vet -> vet.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    //TODO
    @Override
    public Vet findByFirstName(String firstName) {
        return null;
    }

    //TODO
    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet entity) {
        if (entity == null) return null;
        if(entity.getspecialties() == null || entity.getspecialties().size() < 1)
            throw new RuntimeException("Every vet must have some Specialty");

        entity.getspecialties().forEach(Specialty -> {
            if(Specialty.getId() == null) {
                Specialty savedSpecialty = vetSpecialtyService.save(Specialty);
                Specialty.setId(savedSpecialty.getId());
            }
        });

        return super.save(entity);
    }

    @Override
    public Set<Vet> saveAll(List<Vet> entities) {
        Set<Vet> savedEntities = new HashSet<>();
        entities.forEach(entity->savedEntities.add(this.save(entity)));
        return savedEntities;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet entity) {
        super.delete(entity);
    }
}
