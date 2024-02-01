package com.example.prestamolibros.models;

public class Libro {
    private int codigoNum;
    private String titulo;
    private String autor;
    private double costo;
    private int numeroDePaginas; // Nuevo atributo

    // Constructor
    public Libro(int codigoNum, String titulo, String autor, double costo, int numeroDePaginas) {
        this.codigoNum = codigoNum;
        this.titulo = titulo;
        this.autor = autor;
        this.costo = costo;
        this.numeroDePaginas = numeroDePaginas;
    }

    // Getters y Setters
    public int getCodigoNum() {
        return codigoNum;
    }

    public void setCodigoNum(int codigoNum) {
        this.codigoNum = codigoNum;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codigoNum=" + codigoNum +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", costo=" + costo +
                ", numeroDePaginas=" + numeroDePaginas +
                '}';
    }
}
