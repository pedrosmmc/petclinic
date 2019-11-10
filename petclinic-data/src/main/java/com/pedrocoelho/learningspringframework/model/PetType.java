package com.pedrocoelho.learningspringframework.model;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "breeds")
public class PetType extends BaseEntity {
    @Column(name = "denomination")
    private String name;

    public PetType() {
    }

    @Builder
    public PetType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
