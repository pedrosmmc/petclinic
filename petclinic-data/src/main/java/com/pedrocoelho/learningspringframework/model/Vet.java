package com.pedrocoelho.learningspringframework.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "Specialty"))
    private Set<Specialty> specialities = new HashSet<>();

    public Set<Specialty> getSpecialities() {
        return specialities;
    }

    public void addSpecialty(Specialty Specialty) {
        this.specialities.add(Specialty);
    }

    public String specialitiesToString() {
        Iterator<Specialty> it = specialities.iterator();
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
