package com.example.sistemadeventas.models;

import javafx.beans.property.*;

public class Producto {
    private final IntegerProperty id;
    private final StringProperty nombre;
    private final DoubleProperty precio;
    private final ObjectProperty<Categoria> categoria;

    public Producto(int id, String nombre, double precio, Categoria categoria) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleDoubleProperty(precio);
        this.categoria = new SimpleObjectProperty<>(categoria);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public double getPrecio() {
        return precio.get();
    }

    public DoubleProperty precioProperty() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria.get();
    }

    public ObjectProperty<Categoria> categoriaProperty() {
        return categoria;
    }

    @Override
    public String toString() {
        return nombre.get();
    }
}
