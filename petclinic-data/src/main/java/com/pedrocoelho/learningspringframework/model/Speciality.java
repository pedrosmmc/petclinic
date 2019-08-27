package com.pedrocoelho.learningspringframework.model;

public class Speciality extends BaseEntity {
    private String name;

    public Speciality() {
    }

    public Speciality(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
