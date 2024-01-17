package com.example.sistemadeventas.models;

import javafx.beans.property.*;

public class DetalleDePedidoCarrito {
    private final IntegerProperty idDetallePedido;
    private final StringProperty productos;
    private final DoubleProperty precio;
    private final IntegerProperty cantidad;
    private final DoubleProperty subtotal;

    public DetalleDePedidoCarrito() {
        this.idDetallePedido = new SimpleIntegerProperty();
        this.productos = new SimpleStringProperty();
        this.precio = new SimpleDoubleProperty();
        this.cantidad = new SimpleIntegerProperty();
        this.subtotal = new SimpleDoubleProperty();
    }

    // Getter y Setter para idDetallePedido
    public int getIdDetallePedido() {
        return idDetallePedido.get();
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido.set(idDetallePedido);
    }

    public IntegerProperty idDetallePedidoProperty() {
        return idDetallePedido;
    }

    // Getter y Setter para productos
    public String getProductos() {
        return productos.get();
    }

    public void setProductos(String productos) {
        this.productos.set(productos);
    }

    public StringProperty productosProperty() {
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

    // Getter y Setter para cantidad
    public int getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(int cantidad) {
        this.cantidad.set(cantidad);
    }

    public IntegerProperty cantidadProperty() {
        return cantidad;
    }

    // Getter y Setter para subtotal
    public double getSubtotal() {
        return subtotal.get();
    }

    public void setSubtotal(double subtotal) {
        this.subtotal.set(subtotal);
    }

    public DoubleProperty subtotalProperty() {
        return subtotal;
    }
}
