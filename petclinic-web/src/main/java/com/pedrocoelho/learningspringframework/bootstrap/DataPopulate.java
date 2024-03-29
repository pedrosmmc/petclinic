package com.pedrocoelho.learningspringframework.bootstrap;

import com.pedrocoelho.learningspringframework.model.*;
import com.pedrocoelho.learningspringframework.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataPopulate implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataPopulate(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialtyService SpecialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = SpecialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        Address a1 = new Address("Rua da Mesquita", "33", "Beja");
        Address a2 = new Address("June Street", "POBox 213", "Oklahoma");
        Address a3 = new Address("Travessa do Galheiro", "44", "Cucujães");
        Address a4 = new Address("Rua da Fragata", "33", "Braga");
        Address a5 = new Address("Rua da Mesquita", "33", "Beja");
        Address a6 = new Address("Avenida do Brasil", "333", "Lisboa");
        Address a7 = new Address("Avenia do Mercado", "12", "Lixa");



        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        cat.setName("Cat");

        petTypeService.saveAll(Arrays.asList(dog, cat));

        Pet p1 = new Pet("Sancho");
        p1.setBirthDay(LocalDate.of(2000, 1, 13));
        p1.setPetType(dog);
        p1.setSex("Male");

        Pet p2 = new Pet("Georgina");
        p2.setBirthDay(LocalDate.of(2019, 8, 26));
        p2.setPetType(cat);
        p2.setSex("Female");

        Pet p3 = new Pet("Gregory");
        p3.setBirthDay(LocalDate.of(2017, 2, 6));
        p3.setPetType(cat);
        p3.setSex("Male");

        Pet p4 = new Pet("Fanny");
        p4.setBirthDay(LocalDate.of(2017, 2, 6));
        p4.setPetType(dog);
        p4.setSex("Female");

        Pet p5 = new Pet("Pancho");
        p5.setBirthDay(LocalDate.of(2013, 12, 26));
        p5.setPetType(dog);
        p5.setSex("Male");

        Pet p6 = new Pet("Buggy");
        p6.setBirthDay(LocalDate.of(2018, 3, 16));
        p6.setPetType(dog);
        p6.setSex("Female");

        Pet p7 = new Pet("Lalika");
        p7.setBirthDay(LocalDate.of(2016, 11, 16));
        p7.setPetType(cat);
        p7.setSex("Female");

        System.out.println("Populated pets...");

        Owner o1 = Owner.builder().firstName("Pablo").lastName("Gonzalvez").build();
        o1.setAddress(a2);
        a2.setResident(o1);
        o1.setPhoneNumber("5785474328732");
        o1.addPet(p1);
        p1.setOwner(o1);

        Owner o2 = Owner.builder().firstName("Fiona").lastName("Martinez").build();
        o2.setAddress(a3);
        a3.setResident(o2);
        o2.setPhoneNumber("255123234");
        o2.addPet(p4); // Fanny
        p4.setOwner(o2);
        o2.addPet(p5); // Pancho
        p5.setOwner(o2);
        o2.addPet(p6); // Buggy
        p6.setOwner(o2);

        Owner o3 = Owner.builder().firstName("Martha").lastName("Alvarez").build();
        o3.setAddress(a1);
        a1.setResident(o3);
        o3.setPhoneNumber("123123123");
        o3.addPet(p2);
        p2.setOwner(o3);


        Owner o4 = Owner.builder().firstName("Raul").lastName("Alvarez").build();
        o4.setAddress(a5);
        a5.setResident(o4);
        o4.setPhoneNumber("123123123");
        o4.addPet(p3);
        p3.setOwner(o4);

        Owner o5 = Owner.builder().firstName("Raul").lastName("Antunes").build();
        o5.setAddress(a4);
        a4.setResident(o5);
        o5.setPhoneNumber("8456065454");
        o5.addPet(p7);
        p7.setOwner(o5);

        ownerService.saveAll(Arrays.asList(o1, o2, o3, o4, o5));

        System.out.println("Populated owners...");

        Specialty radiology = new Specialty();
        radiology.setDenomination("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDenomination("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDenomination("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Vet v1 = Vet.builder().firstName("Ramirez").lastName("Almeida").build();
        v1.setAddress(a6);
        v1.setPhoneNumber("123321343");
        v1.addSpecialty(savedRadiology);
//
        Vet v2 = Vet.builder().firstName("Roma").lastName("Nowa").build();
        v2.setAddress(a7);
        v2.setPhoneNumber("987543234");
        v2.addSpecialty(savedSurgery);
        v2.addSpecialty(savedDentistry);

//        vetService.saveAll(Arrays.asList(v1, v2));

        System.out.println("Populated vets...");

        Visit visit1 = new Visit();
        visit1.setPet(petService.findById(p1.getId()));
        visit1.setDescription("vacinar");
        visit1.setDate(LocalDate.of(2019, 11, 20));
        visit1.setTime(LocalTime.of(12, 30));

        Visit visit2 = new Visit(LocalDate.of(2019, 11, 29), LocalTime.of(9, 45));
        visit2.setPet(p2);
        visit2.setDescription("fratura exposta");

        Visit visit3 = new Visit(LocalDate.of(2020, 1, 16), LocalTime.of(16, 30));
        visit3.setPet(p3);
        visit3.setDescription("tosquia");

        Visit visit4 = new Visit(LocalDate.of(2019, 11, 20), LocalTime.of(12, 0));
        visit4.setPet(p4);
        visit4.setDescription("remoção de quisto");

        visitService.saveAll(Arrays.asList(visit1, visit2, visit3, visit4));

        System.out.println("Populated visits...");
    }
}
