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
            throw new IllegalArgumentException("La marca no existe"); //Se puede cambiar esta linea de codigo, simplemente es para dar a entender que no exite la marca
        }
    }

    public String existeCategoria(String posibleCategoria) {
        boolean existe = categoria.contains(posibleCategoria);
        if (existe) {
            return posibleCategoria;
        } else {
            throw new IllegalArgumentException("La categoria no existe"); //Se puede cambiar esta linea de codigo, simplemente es para dar a entender que no exite la categoria
        }
    }




    public Refaccion editar(int clave, Refaccion cambio) {
        for (int i = 0; i < db.size(); i++) {
            if(db.get(i).getId() == clave){
                db.set(i, cambio);
            }
        }
        return db.get(clave);
    }

    public Boolean eliminar(int clave) {
        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getId() == clave) {
                db.remove(clave);
                return true;
            }
        }
        throw new IllegalArgumentException("La categoria no existe");
    }

    public Tienda() {
        marca = new ArrayList<>();
        marca.add("BMW");
        marca.add("Ford");
        marca.add("Nissan");

        categoria = new ArrayList<>();
        categoria.add("Faros");
        categoria.add("Bateria");
        categoria.add("Llantas");

        db = new ArrayList<>();
        db.add(new Refaccion(db.size(), "https://www.hangarperformance.com/wp-content/uploads/2020/08/Faros-LED-7p-SIN-ojo-angel.jpg", "Faros Led Lupa Redondo 7pulg", "Bonitos Faros Led con lupa diseñados para un amplio alcance de vision, compatibles con cualquier entrada de 7 pulgadas como un Jeep", existeMarca("BMW"), 2400.00, existeCategoria("Faros") ));
    }
}
