package com.example.sistemadeventas.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Producto {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty nombre = new SimpleStringProperty();
    private final SimpleDoubleProperty precio = new SimpleDoubleProperty();
    private Categoria categoria;

    public Producto() {
    }

    public Producto(int id, String nombre, double precio, Categoria categoria) {
        this.id.set(id);
        this.nombre.set(nombre);
        this.precio.set(precio);
        this.categoria = categoria;
    }

    // Getters para las propiedades
    public int getId() {
        return id.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public double getPrecio() {
        return precio.get();
    }

    // Setters para las propiedades (si es necesario)

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
