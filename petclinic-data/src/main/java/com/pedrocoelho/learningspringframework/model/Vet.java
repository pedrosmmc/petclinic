package com.pedrocoelho.learningspringframework.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality"))
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
            out.append(it.next().getDenomination()).append(", ");
            nSpecs--;
        }
        out.append(it.next().getDenomination());
        return out.toString();
    }
}
