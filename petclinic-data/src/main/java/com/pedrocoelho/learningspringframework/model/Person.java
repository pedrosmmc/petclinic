package com.pedrocoelho.learningspringframework.model;

public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public String getFirtName() {
        return firstName;
    }

    public void setFirtName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
