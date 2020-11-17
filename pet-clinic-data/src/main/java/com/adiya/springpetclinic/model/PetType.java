package com.adiya.springpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

//Lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    private String name;

}
