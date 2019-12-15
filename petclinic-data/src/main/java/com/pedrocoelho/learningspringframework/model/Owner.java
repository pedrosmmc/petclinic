package com.pedrocoelho.learningspringframework.model;

import lombok.Builder;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "owners")
public class Owner extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Builder
    public Owner(Long id, String firstName, String lastName, Set<Pet> pets) throws NoSuchAlgorithmException {
        super(id, firstName, lastName);
        if (pets != null) {
            this.pets = pets;
        }

        String mdString = this.getFirstName()
                + this.getLastName()
                + this.getAddress()
                + this.getPhoneNumber()
                + this.getId();

        super.setReference(super.generateReference(mdString));
    }

    public Owner(Long id, String firstName, String lastName) throws NoSuchAlgorithmException {
        super(id, firstName, lastName);

        String mdString = this.getFirstName()
                + this.getLastName()
                + this.getAddress()
                + this.getPhoneNumber()
                + this.getId();

        super.setReference(super.generateReference(mdString));
    }

    public Owner() throws NoSuchAlgorithmException {
        super();
        String mdString = this.getId() + "";
        super.setReference(super.generateReference(mdString));
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

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + this.getId() + ", " +
                "reference=" + this.getReference() + ", " +
                "firstName=" + this.getFirstName() + ", " +
                "lastName=" + this.getLastName() + ", " +
                "pets=" + pets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        if (!super.equals(o)) return false;
        Owner owner = (Owner) o;
        return Objects.equals(pets, owner.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
