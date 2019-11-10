package com.pedrocoelho.learningspringframework.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "Specialty"))
    private Set<Specialty> specialties = new HashSet<>();

    public Vet(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Set<Specialty> getspecialties() {
        return specialties;
    }

    public void addSpecialty(Specialty Specialty) {
        this.specialties.add(Specialty);
    }

    public String specialtiesToString() {
        Iterator<Specialty> it = specialties.iterator();
        StringBuilder out = new StringBuilder();
        int nSpecs = specialties.size();
        while (nSpecs > 1) {
            out.append(it.next().getDenomination()).append(", ");
            nSpecs--;
        }
        out.append(it.next().getDenomination());
        return out.toString();
    }
}
