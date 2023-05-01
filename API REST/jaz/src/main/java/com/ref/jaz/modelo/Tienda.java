package com.ref.jaz.modelo;

import java.util.ArrayList;

public class Tienda {
    ArrayList<Refaccion> db;
    ArrayList<String> marca;
    ArrayList<String> categoria;

    public String existeMarca(String posibleMarca) {
        boolean existe = marca.contains(posibleMarca);
        if (existe) {
            return posibleMarca;
        } else {
            throw new IllegalArgumentException("La marca no existe"); //Se puede cambiar, simplemente es para dar a entender que no exite la marca
        }
    }


    public Tienda() {
        marca = new ArrayList<>();
        marca.add("BMW");
        marca.add("Ford");
        marca.add("Nissan");
    }
}
