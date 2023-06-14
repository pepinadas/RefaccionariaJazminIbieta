package com.ref.jaz.modelo;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "refaccion")
public class Refaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imagen;
    private String modelo;
    private String descripcion;
    private String marca;
    private int costo;
    private String categoria;
    private int cantidad;
//post vender
    public boolean vender(){
        boolean resultado = false;
        if(cantidad >= 1) {
            cantidad--;
            resultado =  true;
        }
              return resultado;
        }

//post regresar
    public boolean devolver(){
        boolean resultado = false;
        if (cantidad < 50){
            cantidad++;
            resultado=true;
        }
        return resultado;
    }



}
