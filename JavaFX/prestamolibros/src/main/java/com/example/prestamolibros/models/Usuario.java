package com.example.prestamolibros.models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int codigoNum;
    private String nombreCompleto;
    private List<Libro> coleccionDeLibros;

    // Constructor
    public Usuario(int codigoNum, String nombreCompleto) {
        this.codigoNum = codigoNum;
        this.nombreCompleto = nombreCompleto;
        this.coleccionDeLibros = new ArrayList<>();
    }

    // Getters y Setters
    public int getCodigoNum() {
        return codigoNum;
    }

    public void setCodigoNum(int codigoNum) {
        this.codigoNum = codigoNum;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public List<Libro> getColeccionDeLibros() {
        return coleccionDeLibros;
    }

    // Agregar un libro a la colección de libros (hasta un máximo de 5)
    public boolean agregarLibro(Libro libro) {
        if (coleccionDeLibros.size() < 5) {
            coleccionDeLibros.add(libro);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigoNum=" + codigoNum +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", coleccionDeLibros=" + coleccionDeLibros +
                '}';
    }
}
