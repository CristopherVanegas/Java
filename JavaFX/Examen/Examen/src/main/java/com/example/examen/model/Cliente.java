package com.example.examen.model;

public class Cliente {
    private int codigo;
    private String cedula;
    private String fullName;

    public Cliente(int codigo, String cedula, String fullName) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.fullName = fullName;
    }

    // Getters y setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Cliente [codigo=" + codigo + ", cedula=" + cedula + ", fullName=" + fullName + "]";
    }
}
