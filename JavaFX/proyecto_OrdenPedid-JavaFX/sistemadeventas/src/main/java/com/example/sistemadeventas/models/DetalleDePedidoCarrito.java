package com.example.sistemadeventas.models;

import javafx.beans.property.*;
import java.util.List;

public class DetalleDePedidoCarrito {
    private final List<Producto> productos;
    private final DoubleProperty precio;
    private final DoubleProperty subtotal;

    public DetalleDePedidoCarrito(List<Producto> productos) {
        this.productos = productos;
        this.precio = new SimpleDoubleProperty(calcularPrecioTotal());
        this.subtotal = new SimpleDoubleProperty(0.0); // Inicializamos el subtotal en 0.0
        calcularSubtotal(); // Calculamos el subtotal
    }

    // Getter para productos
    public List<Producto> getProductos() {
        return productos;
    }

    // Getter y Setter para precio
    public double getPrecio() {
        return precio.get();
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }

    public DoubleProperty precioProperty() {
        return precio;
    }

    // Getter para subtotal
    public double getSubtotal() {
        return subtotal.get();
    }

    // Método para calcular el subtotal en función de los precios de los productos
    private void calcularSubtotal() {
        double subtotalValue = calcularPrecioTotal();
        this.subtotal.set(subtotalValue);
    }

    // Método para calcular el precio total sumando los precios de los productos
    private double calcularPrecioTotal() {
        double precioTotal = 0.0;
        for (Producto producto : productos) {
            precioTotal += producto.getPrecio();
        }
        return precioTotal;
    }

    public DoubleProperty subtotalProperty() {
        return subtotal;
    }
}
