package com.ref.jaz.modelo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Refaccion {
    private int id;
    private String imagen;
    private String descripcion;
    private String modelo;
    private String marca; //Tal vez deberiamos pensar en declarar esto como un List<String> marca, para que sean valores establecidos y super a menos de que la marca fuera previamente creada, no sea valida, para evitar faltas de ortografia
    private float costo;
    private String categoria; //Lo mismo con esto
}