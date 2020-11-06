package com.aditya.springpetclinic.bootstrap;

import com.adiya.springpetclinic.model.*;
import com.adiya.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    public final SpecialityService specialityService;
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    //Start application with sample data
    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) loadData();

    }

    private void loadData() {
        //Create PetType
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Id: " + dog.getId() + " PetType: " + dog.getName());
        System.out.println("Id: " + cat.getId() + " PetType: " + cat.getName());

        //Create Speciality
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        //Create Onwers
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Stevens");
        owner1.setAddress("123 Street Avenue");
        owner1.setCity("New York City");
        owner1.setTelephone("123145697");
        Pet pet1 = new Pet();
        pet1.setPetType(dog);
        pet1.setName("Pet Name 1");
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);
        ownerService.save(owner1);
        //System.out.println("Owner 1: " + owner1.getFirstName() + " " + owner1.getLastName());
        System.out.println(owner1.toString());

        Owner owner2 = new Owner();
        owner2.setFirstName("Arnold");
        owner2.setLastName("Waltz");
        owner2.setAddress("123 West East Street");
        owner2.setCity("Yankee land");
        owner2.setTelephone("9851522051");
        Pet pet2 = new Pet();
        pet2.setPetType(cat);
        pet2.setName("Pet Name 2");
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);
        ownerService.save(owner2);

        //Create visit for owner 2's cat
        Visit catVisit = new Visit();
        catVisit.setPet(pet2);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Not well");
        visitService.save(catVisit);
        System.out.println(catVisit.toString());

        //System.out.println("Owner 2: " + owner2.getFirstName() + " " + owner2.getLastName());
        System.out.println(owner2.toString());

        //Create Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Derek");
        vet1.setLastName("Muller");
        vet1.getSpecialities().add(savedDentistry);
        vetService.save(vet1);
        System.out.println("Vet 1: " + vet1.getFirstName() + " " + vet1.getLastName());

        Vet vet2 = new Vet();
        vet2.setFirstName("McDonald");
        vet2.setLastName("Trump");
        vet2.getSpecialities().add(savedRadiology);
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Vet 2: " + vet2.getFirstName() + " " + vet2.getLastName());
    }
}

