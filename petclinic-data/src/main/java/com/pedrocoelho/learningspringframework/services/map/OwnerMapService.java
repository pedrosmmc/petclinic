package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.Owner;
import com.pedrocoelho.learningspringframework.model.Pet;
import com.pedrocoelho.learningspringframework.services.OwnerService;
import com.pedrocoelho.learningspringframework.services.PetService;
import com.pedrocoelho.learningspringframework.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile("map-services")
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public List<Owner> findAllByFirstName(String firstName) {
        return map.values().stream().filter(owner -> owner.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Owner> findAllByLastName(String lastName) {
        return map.values().stream().filter(owner -> owner.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public Owner findByFirstName(String firstName) {
        return this.findAll().stream().filter(entity->entity.getFirstName().equals(firstName)).findFirst().orElse(null);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream().filter(entity->entity.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner entity) {
        if (entity == null) return null;
        if (entity.getPets() == null || entity.getPets().size() < 1)
            throw new RuntimeException("Every owner must have some pet");

        entity.getPets().forEach(pet -> {
            if (pet.getPetType() != null) {
                if (pet.getPetType().getId() == null)
                    pet.setPetType(petTypeService.save(pet.getPetType()));
            } else throw new RuntimeException("Pet type is required");

            if (pet.getId() == null) {
                Pet savedPet = petService.save(pet);
                pet.setId(savedPet.getId());
            }
        });

        return super.save(entity);
    }

    @Override
    public Set<Owner> saveAll(List<Owner> entities) {
        Set<Owner> savedEntities = new HashSet<>();
        entities.forEach(entity->savedEntities.add(this.save(entity)));
        return savedEntities;
    }

    @Override
    public void delete(Owner entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
