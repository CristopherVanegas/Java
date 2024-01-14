package com.example.sistemadeventas.models;

public class ClienteMinorista extends Cliente {
    private int numeroCompras;

    // Constructor
    public ClienteMinorista(String cedula, String nombres, String apellidos, String correo, String direccion, String telefono, int numeroCompras) {
        super(cedula, nombres, apellidos, correo, direccion, telefono);
        this.numeroCompras = numeroCompras;
    }

    // Getter y setter para el atributo adicional

    public int getNumeroCompras() {
        return numeroCompras;
    }

    public void setNumeroCompras(int numeroCompras) {
        this.numeroCompras = numeroCompras;
    }
}
