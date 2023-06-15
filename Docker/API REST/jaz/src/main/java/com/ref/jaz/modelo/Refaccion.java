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
    private String modelo;
    private String descripcion;
    private String marca; //Tal vez deberiamos pensar en declarar esto como un List<String> marca, para que sean valores establecidos y super a menos de que la marca fuera previamente creada, no sea valida, para evitar faltas de ortografia
    private double costo;
    private String categoria; //Lo mismo con esto
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
