package com.petclinic.bootstrap;

import com.petclinic.model.Owner;
import com.petclinic.model.Vet;
import com.petclinic.services.OwnerService;
import com.petclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by khayapro on 2018/11/06.
 */
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        final Owner owner1 = new Owner();
        owner1.setName("Sam");
        owner1.setSurname("Brown");

        final Owner owner2 = new Owner();
        owner2.setName("George");
        owner2.setSurname("Browners");
        ownerService.saveAll(Arrays.asList(owner1, owner2));
        log.info("Loaded owners successfully...");
        log.error("owners size: " + ownerService.findAll().size());

        final Vet vet1 = new Vet();
        vet1.setName("Vet");
        vet1.setSurname("Brown");
        vetService.save(vet1);

        final Vet vet2 = new Vet();
        vet2.setName("Vettie");
        vet2.setSurname("Brown");
        vetService.save(vet2);
        log.info("Loaded vets successfully...");
    }
}
