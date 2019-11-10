package com.pedrocoelho.learningspringframework.bootstrap;

import com.pedrocoelho.learningspringframework.model.*;
import com.pedrocoelho.learningspringframework.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

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
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        cat.setName("Cat");

        petTypeService.saveAll(Arrays.asList(dog,cat));

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

        Owner o1 = Owner.builder().firstName("Pablo").lastName("Gonzalvez").build();
        o1.setAddress("June Street, Oklahoma, POBox 213");
        o1.setPhoneNumber("5785474328732");
        o1.addPet(p1);
        p1.setOwner(o1);

        Owner o2 = Owner.builder().firstName("Fiona").lastName("Martinez").build();
        o2.setAddress("Travessa do Galheiro, 44, Cucujães");
        o2.setPhoneNumber("255123234");
        o2.addPet(p4);
        p4.setOwner(o2);

        Owner o3 = Owner.builder().firstName("Martha").lastName("Alvarez").build();
        o3.setAddress("Rua da Mesquita, 33, Los Cacos, Beja");
        o3.setPhoneNumber("123123123");
        o3.addPet(p2);
//        o3.addPet(p3);
        p2.setOwner(o3);


        Owner o4 = Owner.builder().firstName("Raul").lastName("Alvarez").build();
        o4.setAddress("Rua da Mesquita, 33, Los Cacos, Beja");
        o4.setPhoneNumber("123123123");
//        o4.addPet(p2);
        o4.addPet(p3);
        p3.setOwner(o4);


        ownerService.saveAll(Arrays.asList(o1,o2,o3,o4));

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
        v1.setAddress("Avenida do Brasil, 333, Lisboa");
        v1.setPhoneNumber("123321343");
        v1.addSpecialty(savedRadiology);
//
        Vet v2 = Vet.builder().firstName("Roma").lastName("Nowa").build();
        v2.setAddress("Avenia do Mercado, 12, Lixa");
        v2.setPhoneNumber("987543234");
        v2.addSpecialty(savedSurgery);
        v2.addSpecialty(savedDentistry);

        vetService.saveAll(Arrays.asList(v1,v2));

        System.out.println("Populated vets...");

        Visit visit1 = new Visit();
        visit1.setPet(petService.findById(p1.getId()));
        visit1.setDescription("vacinar");
        visit1.setDate(LocalDate.of(2019,11,20));
        visit1.setTime(LocalTime.of(12,30));

        Visit visit2 = new Visit(LocalDate.of(2019,11,29), LocalTime.of(9,45));
        visit2.setPet(p2);
        visit2.setDescription("fratura exposta");

        Visit visit3 = new Visit(LocalDate.of(2020,1,16), LocalTime.of(16,30));
        visit3.setPet(p3);
        visit3.setDescription("tosquia");

        Visit visit4 = new Visit(LocalDate.of(2019,11,20),LocalTime.of(12,0));
        visit4.setPet(p4);
        visit4.setDescription("remoção de quisto");

        visitService.saveAll(Arrays.asList(visit1, visit2, visit3, visit4));

        System.out.println("Populated visits...");
    }
}
