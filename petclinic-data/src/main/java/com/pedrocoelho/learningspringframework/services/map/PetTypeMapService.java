package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.PetType;
import com.pedrocoelho.learningspringframework.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
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
    public List<PetType> findAllByName(String name) {
        return map.values()
                .stream()
                .filter(petType -> petType.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public PetType save(PetType entity) {
        return super.save(entity);
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
