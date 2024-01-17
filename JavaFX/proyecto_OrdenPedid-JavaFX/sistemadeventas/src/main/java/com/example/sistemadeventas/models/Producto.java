package com.example.sistemadeventas.models;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private Categoria categoria;
    private final SimpleObjectProperty<Button> botonAgregarCarrito;

    public Producto(int id, String nombre, double precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;

        Button boton = new Button("Agregar al carrito");
        botonAgregarCarrito = new SimpleObjectProperty<>(boton);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Button getBotonAgregarCarrito() {
        return botonAgregarCarrito.get();
    }

    public SimpleObjectProperty<Button> botonAgregarCarritoProperty() {
        return botonAgregarCarrito;
    }

}
