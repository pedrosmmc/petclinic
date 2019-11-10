package com.pedrocoelho.learningspringframework.model;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDate;

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

    public Pet() {
    }

    @Builder
    public Pet(String name, LocalDate birthDay, String sex, PetType petType, Owner owner) {
        this.name = name;
        this.birthDay = birthDay;
        this.sex = sex;
        this.petType = petType;
        this.owner = owner;
    }

    public PetType getPetType() {
        return petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
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
}
