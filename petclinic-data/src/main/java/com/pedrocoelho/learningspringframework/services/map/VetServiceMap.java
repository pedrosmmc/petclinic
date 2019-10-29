package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.Speciality;
import com.pedrocoelho.learningspringframework.model.Vet;
import com.pedrocoelho.learningspringframework.services.VetService;
import com.pedrocoelho.learningspringframework.services.VetSpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile("map-services")
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private VetSpecialityService vetSpecialityService;

    public VetServiceMap(VetSpecialityService vetSpecialityService) {
        this.vetSpecialityService = vetSpecialityService;
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
        if(entity.getSpecialities() == null || entity.getSpecialities().size() < 1)
            throw new RuntimeException("Every vet must have some speciality");

        entity.getSpecialities().forEach(speciality -> {
            if(speciality.getId() == null) {
                Speciality savedSpeciality = vetSpecialityService.save(speciality);
                speciality.setId(savedSpeciality.getId());
            }
        });

        return super.save(entity);
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
