package com.example.sistemadeventas.models;

import javafx.beans.property.*;

public class Producto {
    private final IntegerProperty id;
    private final StringProperty nombre;
    private final DoubleProperty precio;
    private final ObjectProperty<Categoria> categoria;
    private final StringProperty imagenPath;

    public Producto(int id, String nombre, double precio, Categoria categoria, String imagenPath) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleDoubleProperty(precio);
        this.categoria = new SimpleObjectProperty<>(categoria);
        this.imagenPath = new SimpleStringProperty(imagenPath);
    }
    
    public String getImagenPath() {
        return imagenPath.get();
    }
    
    public StringProperty imagenPathProperty() {
        return imagenPath;
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
