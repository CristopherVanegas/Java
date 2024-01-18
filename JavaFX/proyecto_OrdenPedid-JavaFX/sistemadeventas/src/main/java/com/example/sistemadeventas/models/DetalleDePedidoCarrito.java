package com.example.sistemadeventas.models;

import java.util.List;

public class DetalleDePedidoCarrito {
    private List<Producto> productos;
    private double precio;
    private double subtotal;

    public DetalleDePedidoCarrito() {
        // Constructor sin argumentos para deserialización
    }

    // Agregar un constructor que se adapte a la creación de un nuevo DetalleDePedidoCarrito
    public DetalleDePedidoCarrito(List<Producto> carrito) {
        this.productos = carrito;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    // Getters y setters para los campos primitivos
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
