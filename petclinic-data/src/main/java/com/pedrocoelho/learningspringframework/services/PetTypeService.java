package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.PetType;

import java.util.List;

public interface PetTypeService extends BaseService<PetType,Long> {
    List<PetType> findAllByName(String name);
}
