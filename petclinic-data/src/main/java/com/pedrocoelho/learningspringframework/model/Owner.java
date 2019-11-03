package com.pedrocoelho.learningspringframework.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Pet getPet(String name) {
        return pets.stream().filter(pet->pet.getName().equals(name)).findFirst().orElse(null);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }

    public String petsToString() {
        return pets.stream().map(Pet::getName).collect(Collectors.joining(", "));
    }
}
