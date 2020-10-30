package com.adiya.springpetclinic.services;

import com.adiya.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAVet();
}
