package com.pedrocoelho.learningspringframework.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String firstName, String lastName, Set<Pet> pets) {
        super(id, firstName, lastName);

        if (pets != null) {
            this.pets = pets;
        }
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public Pet getPet(String name) {
        return pets.stream().filter(pet -> pet.getName().equals(name)).findFirst().orElse(null);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }

    public String petsToString() {
        return pets.stream().map(Pet::getName).collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + this.getId() + ", " +
                "firstName=" + this.getFirstName() + ", " +
                "lastName=" + this.getLastName() + ", " +
                "pets=" + pets +
                '}';
    }
}
