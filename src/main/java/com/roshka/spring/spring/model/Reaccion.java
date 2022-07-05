package com.roshka.spring.spring.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Reaccion {

    @Id
    @GeneratedValue
    private Long id;
    private String tipo;

    private String icono;

}