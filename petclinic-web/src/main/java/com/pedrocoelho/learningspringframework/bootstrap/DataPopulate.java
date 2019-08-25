package com.pedrocoelho.learningspringframework.bootstrap;

import com.pedrocoelho.learningspringframework.model.Owner;
import com.pedrocoelho.learningspringframework.model.Pet;
import com.pedrocoelho.learningspringframework.model.Vet;
import com.pedrocoelho.learningspringframework.services.OwnerService;
import com.pedrocoelho.learningspringframework.services.PetService;
import com.pedrocoelho.learningspringframework.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataPopulate implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;

    public DataPopulate(OwnerService ownerService, VetService vetService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner o1 = new Owner();
        o1.setFirstName("Pablo");
        o1.setLastName("Gonzalvez");

        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Fiona");
        o2.setLastName("Martinez");

        ownerService.save(o2);

        Owner o3 = new Owner();
        o3.setFirstName("Martha");
        o3.setLastName("Alvarez");

        ownerService.save(o3);

        System.out.println("Populated owners...");

        Vet v1 = new Vet();
        v1.setFirstName("Ramirez");
        v1.setLastName("Almeida");

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Roma");
        v2.setLastName("Nowa");

        vetService.save(v2);

        System.out.println("Populated vets...");

        Pet p1 = new Pet();
        p1.setName("Sancho");

        petService.save(p1);

        Pet p2 = new Pet();
        p2.setName("Giorgina");

        petService.save(p2);

        System.out.println("Populated pets...");
    }
}
