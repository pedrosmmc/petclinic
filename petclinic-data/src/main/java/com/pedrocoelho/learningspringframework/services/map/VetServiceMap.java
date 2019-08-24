package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.Vet;
import com.pedrocoelho.learningspringframework.services.VetService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public List<Vet> findAllByFirstName(String firstName) {
        return map.values().stream().filter(vet -> vet.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vet> findAllByLastName(String lastName) {
        return map.values().stream().filter(vet -> vet.getLastName().equals(lastName))
                .collect(Collectors.toList());
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
        return super.save(entity.getId(), entity);
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
