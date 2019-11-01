package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Specialty;

public interface SpecialtyService extends CrudeService<Specialty, Long> {
    Specialty findByName(String denomination);
}
