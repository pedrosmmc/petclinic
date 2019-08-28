package com.pedrocoelho.learningspringframework.bootstrap;

import com.pedrocoelho.learningspringframework.model.*;
import com.pedrocoelho.learningspringframework.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataPopulate implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataPopulate(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        cat.setName("Cat");

        Pet p1 = new Pet();
        p1.setName("Sancho");
        p1.setBirthDay(LocalDate.of(2000,1,13));
        p1.setPetType(dog);
        p1.setSex("Male");

        Pet p2 = new Pet();
        p2.setName("Georgina");
        p2.setBirthDay(LocalDate.of(2019,8,26));
        p2.setPetType(cat);
        p2.setSex("Female");

        Pet p3 = new Pet();
        p3.setName("Gregory");
        p3.setBirthDay(LocalDate.of(2017,2,6));
        p3.setPetType(cat);
        p3.setSex("Male");

        Pet p4 = new Pet();
        p4.setName("Fanny");
        p4.setBirthDay(LocalDate.of(2017,2,6));
        p4.setPetType(dog);
        p4.setSex("Female");

        System.out.println("Populated pets...");
        Owner o1 = new Owner();
        o1.setFirstName("Pablo");
        o1.setLastName("Gonzalvez");
        o1.setAddress("June Street, Oklahoma, POBox 213");
        o1.setPhoneNumber("5785474328732");
        o1.addPet(p1);
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Fiona");
        o2.setLastName("Martinez");
        o2.setAddress("Travessa do Galheiro, 44, Cucujães");
        o2.setPhoneNumber("255123234");
        o2.addPet(p4);
        ownerService.save(o2);

        Owner o3 = new Owner();
        o3.setFirstName("Martha");
        o3.setLastName("Alvarez");
        o3.setAddress("Rua da Mesquita, 33, Los Cacos, Beja");
        o3.setPhoneNumber("123123123");
        o3.addPet(p2);
        o3.addPet(p3);
        ownerService.save(o3);

        Owner o4 = new Owner();
        o4.setFirstName("Raul");
        o4.setLastName("Alvarez");
        o4.setAddress("Rua da Mesquita, 33, Los Cacos, Beja");
        o4.setPhoneNumber("123123123");
        o4.addPet(p2);
        o4.addPet(p3);
        ownerService.save(o4);

        System.out.println("Populated owners...");

        Speciality sp1 = new Speciality();
        sp1.setName("dog_speciality");
        Speciality sp2 = new Speciality();
        sp2.setName("cat_speciality");
        Speciality sp3 = new Speciality();
        sp3.setName("bird_speciality");

        Vet v1 = new Vet();
        v1.setFirstName("Ramirez");
        v1.setLastName("Almeida");
        v1.setAddress("Avenida do Brasil, 333, Lisboa");
        v1.setPhoneNumber("123321343");
        v1.addSpeciality(sp1);
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Roma");
        v2.setLastName("Nowa");
        v2.setAddress("Avenia do Mercado, 12, Lixa");
        v2.setPhoneNumber("987543234");
        v2.addSpeciality(sp2);
        v2.addSpeciality(sp3);
        vetService.save(v2);

        System.out.println("Populated vets...");
    }
}
