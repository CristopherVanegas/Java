package com.example.examen.model;

public class Pelicula {
    private String nombrePelicula;

    public Pelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    @Override
    public String toString() {
        return "Pelicula [nombrePelicula=" + nombrePelicula + "]";
    }
}
