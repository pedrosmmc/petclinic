package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.Pet;
import com.pedrocoelho.learningspringframework.services.BaseService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements BaseService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public void delete(Pet entity) {
        super.delete(entity);
    }
}
