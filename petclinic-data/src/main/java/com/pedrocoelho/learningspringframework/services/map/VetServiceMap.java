package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.Vet;
import com.pedrocoelho.learningspringframework.services.BaseService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements BaseService<Vet, Long> {
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
    public void delete(Vet entity) {
        super.delete(entity);
    }
}
