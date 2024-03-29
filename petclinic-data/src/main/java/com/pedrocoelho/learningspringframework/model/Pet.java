package com.pedrocoelho.learningspringframework.model;

import lombok.Builder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDay;
    @Column(name = "sex")
    private String sex; // male 0, female 1

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Pet() throws NoSuchAlgorithmException {
        super();
        String mdString = getId() + "";
        super.setReference(super.generateReference(mdString));
    }

        public Pet(String name) throws NoSuchAlgorithmException {
        super();
        this.name = name;
        String mdString = this.getId() + this.name;
        super.setReference(super.generateReference(mdString));
    }

    @Builder
    public Pet(String name, LocalDate birthDay, String sex, PetType petType, Owner owner) throws NoSuchAlgorithmException {
        this.name = name;
        this.birthDay = birthDay;
        this.sex = sex;
        this.petType = petType;
        this.owner = owner;

        String mdString = this.getId()
                + this.name
                + this.sex
                + this.birthDay
                + this.petType
                + this.owner;

        super.setReference(super.generateReference(mdString));
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name) &&
                Objects.equals(birthDay, pet.birthDay) &&
                Objects.equals(sex, pet.sex) &&
                Objects.equals(petType, pet.petType) &&
                Objects.equals(owner, pet.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, birthDay, sex, petType, owner);
    }
}
