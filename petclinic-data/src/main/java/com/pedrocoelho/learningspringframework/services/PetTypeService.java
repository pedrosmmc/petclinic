package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.PetType;

public interface PetTypeService extends CrudeService<PetType,Long> {
    PetType findByName(String name);
}
