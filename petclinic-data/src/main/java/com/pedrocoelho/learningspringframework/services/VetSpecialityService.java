package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Speciality;

public interface VetSpecialityService extends CrudeService<Speciality, Long> {
    Speciality findByName(String denomination);
}
