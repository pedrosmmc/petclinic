package com.pedrocoelho.learningspringframework.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Visit extends BaseEntity {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private Pet pet;

    public Visit() {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}