package com.pedrocoelho.learningspringframework.repositories;

import com.pedrocoelho.learningspringframework.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AddressRepository extends CrudRepository<Address, Long> {
    Set<Address> findAllByCountry(String country);

    Set<Address> findAllByDistrict(String district);

    Set<Address> findAllByCity(String city);

    Set<Address> findAllByStreet(String street);

    Address findByStreetAndDoor(String street, String door);

    Address findByStreetAndDoorAndFloor(String street, String door, String floor);
}
