package com.pedrocoelho.learningspringframework.model;

import lombok.Builder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "Specialty"))
    private Set<Specialty> specialties = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Builder
    public Vet(Long id, String firstName, String lastName) throws NoSuchAlgorithmException {
        super(id, firstName, lastName);
        String mdString = this.getFirstName()
                + this.getLastName()
                + this.getAddress()
                + this.getPhoneNumber()
                + this.getId();

        super.setReference(super.generateReference(mdString));
    }

    public Vet() throws NoSuchAlgorithmException {
        super();String mdString = this.getId() + "";
        super.setReference(super.generateReference(mdString));
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

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String generateReference() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(ReflectionToStringBuilder.toString(this).getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
