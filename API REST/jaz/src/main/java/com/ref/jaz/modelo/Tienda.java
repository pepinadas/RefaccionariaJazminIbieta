package com.ref.jaz.modelo;

import java.util.ArrayList;


public class Tienda {
    ArrayList<Refaccion> db;
    ArrayList<String> marca;
    ArrayList<String> categoria;

    ArrayList<String> carrito;

    int ventas = 0;

    //Get mostrando el articulo por ID
    public Refaccion id(int id) {
        return db.get(id);
    }

    //Get mostrando todo el stock
    public Tienda(ArrayList<Refaccion> db) {
        this.db = db;
    }
    public ArrayList<Refaccion> getDb(){
        return db;
    }

    //Funciones utiles para verificar si existe o no la categoria o la marca
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

   //Post y funcion comprar

    public boolean comprar(int modelo) {
        Refaccion refaccion =null;
        for (int i = 0; i < db.size(); i++) {
            if(db.get(i).getId() == modelo){
                refaccion = db.get(i);
                break;
            }
        }
        if (refaccion != null){
            return refaccion.vender();
        }else{
            return false;
        }
    }

    //Post regresar articulo

    public boolean regresar (int id) {
        Refaccion refaccion =null;
            if(refaccion == null){
                return false;
            }else{
                return refaccion.devolver();
            }
    }

    //Patch para editar un producto ya existente
    public Refaccion editar(int clave, Refaccion cambio) {
        for (int i = 0; i < db.size(); i++) {
            if(db.get(i).getId() == clave){
                db.set(i, cambio);
            }
        }
        return db.get(clave);
    }

    //Borrar un producto
    public Boolean eliminar(int clave) {
        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getId() == clave) {
                db.remove(clave);
                return true;
            }
        }
        throw new IllegalArgumentException("La categoria no existe");
    }


    //Base de datos
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
        db.add(new Refaccion(db.size(),  "https://www.hangarperformance.com/wp-content/uploads/2020/08/Faros-LED-7p-SIN-ojo-angel.jpg", "Faros Led Lupa Redondo 7pulg", "Bonitos Faros Led con lupa diseñados para un amplio alcance de vision, compatibles con cualquier entrada de 7 pulgadas como un Jeep", existeMarca("BMW"), 2400.00, existeCategoria("Faros"), 40));
        db.add(new Refaccion(db.size(),  "https://m.media-amazon.com/images/I/512r3gH059L._AC_SY450_.jpg", "Bujia", "Bujia para carros BMW", existeMarca("BMW"), 100.00, existeCategoria("Bateria"), 100));
        db.add(new Refaccion(db.size(),  "https://m.media-amazon.com/images/I/51Mqp+oaeWL._AC_.jpg", "Faros ", "Faro Izquierdo/Piloto DEPO", existeMarca("Ford"), 654.00, existeCategoria("Faros"), 20));
        db.add(new Refaccion(db.size(),  "https://m.media-amazon.com/images/I/41+5tG6LuML._AC_SX450_.jpg", "Bateria", "LTH BATERIA AGM L-47-660AGM", existeMarca("Nissan"), 2400.00, existeCategoria("Bateria"), 60));
        db.add(new Refaccion(db.size(),  "https://m.media-amazon.com/images/I/81uRTxv1GxL.__AC_SX300_SY300_QL70_ML2_.jpg", "Faros", "Conjunto de faros delanteros de cobalto, reflector de repuesto", existeMarca("BMW"), 2600.00, existeCategoria("Faros"), 10));
    }
}
