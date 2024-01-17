package com.example.sistemadeventas.models;

import java.util.Date;
import java.util.List;

public class Pedido {
    private int idPedido;
    private String cliente;
    private Date fecha;
    private String formaDeEnvio;
    private String estadoDelPedido;
    private List<DetalleDePedidoCarrito> listaDetalleDePedidoCarrito;

    public Pedido(int idPedido, String cliente, Date fecha, String formaDeEnvio, String estadoDelPedido, List<DetalleDePedidoCarrito> listaDetalleDePedidoCarrito) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.fecha = fecha;
        this.formaDeEnvio = formaDeEnvio;
        this.estadoDelPedido = estadoDelPedido;
        this.listaDetalleDePedidoCarrito = listaDetalleDePedidoCarrito;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFormaDeEnvio() {
        return formaDeEnvio;
    }

    public void setFormaDeEnvio(String formaDeEnvio) {
        this.formaDeEnvio = formaDeEnvio;
    }

    public String getEstadoDelPedido() {
        return estadoDelPedido;
    }

    public void setEstadoDelPedido(String estadoDelPedido) {
        this.estadoDelPedido = estadoDelPedido;
    }

    public List<DetalleDePedidoCarrito> getListaDetalleDePedidoCarrito() {
        return listaDetalleDePedidoCarrito;
    }

    public void setListaDetalleDePedidoCarrito(List<DetalleDePedidoCarrito> listaDetalleDePedidoCarrito) {
        this.listaDetalleDePedidoCarrito = listaDetalleDePedidoCarrito;
    }
}
