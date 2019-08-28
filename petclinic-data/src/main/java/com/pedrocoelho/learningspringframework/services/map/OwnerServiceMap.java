package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.Owner;
import com.pedrocoelho.learningspringframework.model.Pet;
import com.pedrocoelho.learningspringframework.services.OwnerService;
import com.pedrocoelho.learningspringframework.services.PetService;
import com.pedrocoelho.learningspringframework.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
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

            if(pet.getId() == null) {
                Pet savedPet = petService.save(pet);
                pet.setId(savedPet.getId());
            }
        });

        return super.save(entity);
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
