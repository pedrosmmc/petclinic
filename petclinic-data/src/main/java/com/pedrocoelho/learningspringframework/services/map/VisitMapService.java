package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.Visit;
import com.pedrocoelho.learningspringframework.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile("map-services")
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit entity) {
        if (entity.getPet() == null ||
                entity.getPet().getOwner() == null ||
                entity.getPet().getId() == null ||
                entity.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid visit!");
        return super.save(entity);
    }

    @Override
    public Set<Visit> saveAll(List<Visit> entities) {
        Set<Visit> savedEntities = new HashSet<>();
        entities.forEach(entity->savedEntities.add(this.save(entity)));
        return savedEntities;
    }

    @Override
    public void delete(Visit entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit findByDate(LocalDate date) {
        return map.values().stream()
                .filter(visit -> visit.getDate().equals(date))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Visit findByTime(LocalTime time) {
        return map.values().stream()
                .filter(visit -> visit.getTime().equals(time))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Visit findByDateAndTime(LocalDate date, LocalTime time) {
        return map.values().stream()
                .filter(visit -> visit.getDate().equals(date))
                .collect(Collectors.toList()).stream()
                .filter(visit -> visit.getTime().equals(time))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Visit> findAllByDate(LocalDate date) {
        return map.values().stream().filter(visit -> visit.getDate().equals(date)).collect(Collectors.toSet());
    }

    @Override
    public Visit findByPetName(String petName) {
        return map.values().stream()
                .filter(visit -> visit.getPet().getName().equals(petName))
                .findFirst()
                .orElse(null);
    }
}
