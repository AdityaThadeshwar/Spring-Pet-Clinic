package com.aditya.springpetclinic.bootstrap;

import com.adiya.springpetclinic.model.Owner;
import com.adiya.springpetclinic.model.Vet;
import com.adiya.springpetclinic.services.OwnerService;
import com.adiya.springpetclinic.services.VetService;
import com.adiya.springpetclinic.services.map.OwnerServiceMap;
import com.adiya.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    //Start application with sample data
    @Override
    public void run(String... args) throws Exception {

        //Create Onwers
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Stevens");
        owner1.setId(1L);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Arnold");
        owner2.setLastName("Waltz");
        owner2.setId(2L);
        ownerService.save(owner2);

        //Create Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Derek");
        vet1.setLastName("Muller");
        vet1.setId(1L);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("McDonald");
        vet2.setLastName("Trump");
        vet2.setId(2L);
        vetService.save(vet2);


    }
}
