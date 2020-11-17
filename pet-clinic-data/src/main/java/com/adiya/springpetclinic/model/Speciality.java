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
@Table(name = "specialties")
public class Speciality extends BaseEntity {

    private String description;

}
