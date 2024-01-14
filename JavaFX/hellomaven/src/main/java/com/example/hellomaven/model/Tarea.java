package com.example.hellomaven.model;

public class Tarea {
    private String nombre;
    private boolean completada;

    // Constructor por defecto
    public Tarea() {
    }

    // Constructor que acepta nombre y estado de completado
    public Tarea(String nombre, boolean completada) {
        this.nombre = nombre;
        this.completada = completada;
    }

    // Getter y Setter para el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para el estado de completado
    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "nombre='" + nombre + '\'' +
                ", completada=" + completada +
                '}';
    }
}
