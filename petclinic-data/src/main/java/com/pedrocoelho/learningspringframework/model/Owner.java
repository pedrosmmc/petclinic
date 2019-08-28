package com.pedrocoelho.learningspringframework.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Owner extends Person {

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
