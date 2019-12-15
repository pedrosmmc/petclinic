package com.pedrocoelho.learningspringframework.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    public String street;
    public String door;
    public String floor;
    public String city;
    public String district;
    public String country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private Set<Person> residents = new HashSet<>();

    public Address(String street, String door, String city) {
        super();
        this.street = street;
        this.door = door;
        this.city = city;
    }

    public Address(String street, String door, String floor, String city) {
        super();
        this.street = street;
        this.door = door;
        this.floor = floor;
        this.city = city;
    }

    public Address(String street, String door, String floor, String city, String district, String country) {
        super();
        this.street = street;
        this.door = door;
        this.floor = floor;
        this.city = city;
        this.district = district;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Person> getResidents() {
        return residents;
    }

    public void setResidents(Set<Person> residents) {
        this.residents = residents;
    }

    public void setResident(Person resident) {
        this.residents.add(resident);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(door, address.door) &&
                Objects.equals(floor, address.floor) &&
                Objects.equals(city, address.city) &&
                Objects.equals(district, address.district) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, door, floor, city, district, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", door='" + door + '\'' +
                ", floor='" + floor + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
