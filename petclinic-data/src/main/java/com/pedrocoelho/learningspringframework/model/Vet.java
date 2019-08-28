package com.pedrocoelho.learningspringframework.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Vet extends Person {
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void addSpeciality(Speciality speciality) {
        this.specialities.add(speciality);
    }

    public String specialitiesToString() {
        Iterator<Speciality> it = specialities.iterator();
        StringBuilder out = new StringBuilder();
        int nSpecs = specialities.size();
        while (nSpecs > 1) {
            out.append(it.next().getName()).append(", ");
            nSpecs--;
        }
        out.append(it.next().getName());
        return out.toString();
    }
}
