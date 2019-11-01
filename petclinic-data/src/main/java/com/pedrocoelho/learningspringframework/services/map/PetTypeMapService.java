package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.PetType;
import com.pedrocoelho.learningspringframework.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("map-services")
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType findByName(String name) {
        return map.values()
                .stream()
                .filter(petType -> petType.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public PetType save(PetType entity) {
        return super.save(entity);
    }

    @Override
    public Set<PetType> saveAll(List<PetType> entities) {
        Set<PetType> savedEntities = new HashSet<>();
        entities.forEach(entity->savedEntities.add(this.save(entity)));
        return savedEntities;
    }

    @Override
    public void delete(PetType entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
