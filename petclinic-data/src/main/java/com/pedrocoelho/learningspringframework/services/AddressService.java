package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Address;

import java.util.Set;

public interface AddressService extends CrudeService<Address, Long> {

    Set<Address> findAllByCountry(String country);

    Set<Address> findAllByDistrict(String district);

    Set<Address> findAllByCity(String city);

    Set<Address> findAllByStreet(String street);

    Address findByStreetAndDoor(String street, String door);

    Address findByStreetAndDoorAndFloor(String street, String door, String floor);
}
