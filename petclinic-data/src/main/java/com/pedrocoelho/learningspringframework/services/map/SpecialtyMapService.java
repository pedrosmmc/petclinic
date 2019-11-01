package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.Specialty;
import com.pedrocoelho.learningspringframework.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("map-services")
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Specialty findByName(String denomination) {
        return map.values().stream().filter(Specialty -> Specialty.getDenomination().equals(denomination)).findFirst().orElse(null);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty entity) {
        return super.save(entity);
    }

    @Override
    public Set<Specialty> saveAll(List<Specialty> entities) {
        Set<Specialty> savedEntities =new HashSet<>();
        entities.forEach(entity->savedEntities.add(this.save(entity)));
        return savedEntities;
    }

    @Override
    public void delete(Specialty entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
