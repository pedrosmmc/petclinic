package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.Speciality;
import com.pedrocoelho.learningspringframework.services.VetSpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile("map-services")
public class VetSpecialityServiceMap extends AbstractMapService<Speciality, Long> implements VetSpecialityService {
    @Override
    public Speciality findByName(String name) {
        return map.values().stream().filter(speciality -> speciality.getDenomination().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality entity) {
        return super.save(entity);
    }

    @Override
    public void delete(Speciality entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
