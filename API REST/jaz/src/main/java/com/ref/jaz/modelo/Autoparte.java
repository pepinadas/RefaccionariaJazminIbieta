package com.ref.jaz.modelo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Autoparte {
    private int id;
    private String imagen;
    private String descripcion;
    private String modelo;
    private String marca;
    private float costo;
    private String categoria;
}
