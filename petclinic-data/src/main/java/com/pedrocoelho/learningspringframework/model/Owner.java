package com.pedrocoelho.learningspringframework.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Set<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }

    public String petsToString() {
        if(pets.size() == 0) return "";
        Iterator<Pet> it = pets.iterator();
        StringBuilder out = new StringBuilder();
        int nPets = pets.size();
        while (nPets > 1) {
            out.append(it.next().getName()).append(", ");
            nPets--;
        }
        out.append(it.next().getName());
        return out.toString();
    }
}
