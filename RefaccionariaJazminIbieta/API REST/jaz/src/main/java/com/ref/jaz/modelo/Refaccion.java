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


    //Metodos de acceso
    public int getId() {
        return id;
    }

    public String getImagen() {
        return imagen;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public double getCosto() {
        return costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Refaccion{" +
                "id=" + id +
                ", imagen='" + imagen + '\'' +
                ", modelo='" + modelo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
