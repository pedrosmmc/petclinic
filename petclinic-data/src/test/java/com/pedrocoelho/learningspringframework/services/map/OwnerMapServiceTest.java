package com.pedrocoelho.learningspringframework.services.map;

import com.pedrocoelho.learningspringframework.model.Owner;
import com.pedrocoelho.learningspringframework.model.Pet;
import com.pedrocoelho.learningspringframework.model.PetType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    final long ownerId = 330L;
    final String firstName = "Hugo";
    final String lastName = "Test";

    private Pet p1, p2;
    private Owner o1, o2, o3;

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() throws NoSuchAlgorithmException {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        PetType pt1 = new PetType("kitty");
        p1 = new Pet();
        p1.setSex("F");
        p1.setName("Yahsmin Test");
        p1.setPetType(pt1);

        p2 = new Pet();
        p2.setSex("M");
        p2.setName("Simão Test");
        p2.setPetType(pt1);

        o1 = ownerMapService.save(Owner.builder()
                .id(ownerId)
                .firstName(firstName)
                .lastName(lastName)
                .pets(new HashSet<>(Arrays.asList(p1, p2)))
                .build());

        ownerMapService.save(Owner.builder()
                .id(333L)
                .firstName("Rui")
                .lastName("Madeira")
                .pets(new HashSet<>(Arrays.asList(p1, p2)))
                .build());

        ownerMapService.save(Owner.builder()
                .id(331L)
                .firstName("Rita")
                .lastName("Arthur")
                .pets(new HashSet<>(Arrays.asList(p1, p2)))
                .build());
    }

    @AfterEach
    void tearDown() {
        ownerMapService.findAll().forEach(System.out::println);
    }

    @Test
    void findAllByFirstName() {
        Owner owner = new ArrayList<>(ownerMapService.findAllByFirstName(firstName)).get(0);
        assertNotNull(owner);
        assertEquals(owner.getFirstName(), firstName);
    }

    @Test
    void findAllByLastName() {
        Owner owner = ownerMapService.findAllByLastName(lastName).stream().collect(Collectors.toList()).get(0);
        assertEquals(owner.getLastName(), lastName);

    }

    @Test
    void findByFirstName() {//Todo
        Owner owner = ownerMapService.findByFirstName(firstName);
        assertNotNull(owner);
        assertEquals(owner.getFirstName(), firstName);
    }

    @Test
    void findByLastName() {//TODO
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(owner.getLastName(), lastName);
    }

    @Test
    void findByFirstNameNotFound() {
        Owner owner = ownerMapService.findByFirstName("foo");
        assertNull(owner);
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerMapService.findByLastName("foo");
        assertNull(owner);
    }

    @Test
    void findAll() {
        assertEquals(ownerMapService.findAll().size(), 3);

    }

    @Test
    void findById() {
        assertEquals(ownerMapService.findById(ownerId).getId(), ownerId);
    }

    @Test
    void save() throws NoSuchAlgorithmException {
        Owner o4 = Owner.builder()
                .id(332L)
                .firstName("Sofia")
                .lastName("Coelho")
                .pets(new HashSet<>(Arrays.asList(p1, p2)))
                .build();

        ownerMapService.save(o4);

        assertEquals(ownerMapService.findAll().size(), 4);
    }

    @Test
    void saveAll() throws NoSuchAlgorithmException {
        Owner o4 = Owner.builder()
                .id(332L)
                .firstName("Sofia")
                .lastName("Coelho")
                .pets(new HashSet<>(Arrays.asList(p1, p2)))
                .build();

        Owner o5 = Owner.builder()
                .id(334L)
                .firstName("Rangner")
                .lastName("Lothbrok")
                .pets(new HashSet<>(Arrays.asList(p1, p2)))
                .build();

        ownerMapService.saveAll(Arrays.asList(o4, o5));

        assertEquals(ownerMapService.findAll().size(), 5);
    }

    @Test
    void saveExistingId() throws NoSuchAlgorithmException {
        Owner o6 = ownerMapService.save(Owner.builder()
                .id(ownerId)
                .firstName("Rangner")
                .lastName("Lothbrok")
                .pets(new HashSet<>(Arrays.asList(p1, p2)))
                .build());

        assertEquals(o6.getId(), ownerId);
        assertNotEquals(o6.getFirstName(),firstName);
    }

    @Test
    void saveNoId() throws NoSuchAlgorithmException {
        Owner o7 = ownerMapService.save(Owner.builder()
                .firstName("Scofield")
                .lastName("John")
                .pets(new HashSet<>(Arrays.asList(p1, p2)))
                .build());

        assertNotNull(o7);
        assertNotNull(o7.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(o1);

        assertEquals(ownerMapService.findAll().size(), 2);
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(ownerMapService.findAll().size(), 2);
    }
}