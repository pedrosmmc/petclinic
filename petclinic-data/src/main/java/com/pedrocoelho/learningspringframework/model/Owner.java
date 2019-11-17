package com.pedrocoelho.learningspringframework.model;

import lombok.Builder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
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

    @Builder
    public Owner(Long id, String firstName, String lastName, Set<Pet> pets) throws NoSuchAlgorithmException {
        super(id, firstName, lastName);
        if (pets != null) {
            this.pets = pets;
        }
        super.setReference(this.generateReference());
        System.out.println(this.getReference());
    }

    public Owner(Long id, String firstName, String lastName) throws NoSuchAlgorithmException {
        super(id, firstName, lastName);
        super.setReference(this.generateReference());
    }

    public Owner() throws NoSuchAlgorithmException {
        super();
        super.setReference(this.generateReference());
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

    public String generateReference() throws NoSuchAlgorithmException {

        String mdString = this.getFirstName()
                + this.getLastName()
                + this.getAddress()
                + this.getCity()
                + this.getPhoneNumber()
                + this.getId();

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(mdString.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
