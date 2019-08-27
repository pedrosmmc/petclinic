package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.PetType;

import java.util.List;

public interface PetTypeService extends BaseService<PetType,Long> {
    PetType findByName(String name);
}
