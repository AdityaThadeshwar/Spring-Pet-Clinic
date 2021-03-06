package com.adiya.springpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//Lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", petType=" + petType +
                ", owner=" + owner +
                ", birthDate=" + birthDate +
                ", visits=" + visits +
                '}';
    }
}
