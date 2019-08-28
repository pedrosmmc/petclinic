package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Speciality;

public interface VetSpecialityService extends BaseService<Speciality, Long> {
    Speciality findByName(String name);
}
