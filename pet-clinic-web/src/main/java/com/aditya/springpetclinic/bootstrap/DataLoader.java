package com.aditya.springpetclinic.bootstrap;

import com.adiya.springpetclinic.model.Owner;
import com.adiya.springpetclinic.model.PetType;
import com.adiya.springpetclinic.model.Vet;
import com.adiya.springpetclinic.services.OwnerService;
import com.adiya.springpetclinic.services.PetTypeService;
import com.adiya.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    //Start application with sample data
    @Override
    public void run(String... args) throws Exception {

        //Create PetType
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Id: " + dog.getId() +" PetType: " + dog.getName());
        System.out.println("Id: " + cat.getId() +" PetType: " + cat.getName());

        //Create Onwers
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Stevens");
        ownerService.save(owner1);
        System.out.println("Owner 1: " + owner1.getFirstName() + " " + owner1.getLastName());

        Owner owner2 = new Owner();
        owner2.setFirstName("Arnold");
        owner2.setLastName("Waltz");
        ownerService.save(owner2);
        System.out.println("Owner 2: " + owner2.getFirstName() + " " + owner2.getLastName());

        //Create Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Derek");
        vet1.setLastName("Muller");
        vetService.save(vet1);
        System.out.println("Vet 1: " + vet1.getFirstName() + " " + vet1.getLastName());

        Vet vet2 = new Vet();
        vet2.setFirstName("McDonald");
        vet2.setLastName("Trump");
        vetService.save(vet2);
        System.out.println("Vet 2: " + vet2.getFirstName() + " " + vet2.getLastName());


    }
}

