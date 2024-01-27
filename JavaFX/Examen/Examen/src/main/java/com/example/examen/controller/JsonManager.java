package com.example.examen.controller;

import com.example.examen.model.Cliente;
import com.example.examen.model.Pelicula;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonManager {

    private static final String CLIENTES_JSON_PATH = "src/main/java/com/example/examen/DATA/clientes.json";
    private static final String PELICULAS_JSON_PATH = "src/main/java/com/example/examen/DATA/peliculas.json";

    private List<Cliente> clientes = new ArrayList<>();
    private List<Pelicula> peliculas = new ArrayList<>();

    public JsonManager() {
        cargarClientesDesdeJson();
        cargarPeliculasDesdeJson();
        
        // Inicializar al menos 10 clientes y películas si las listas están vacías
        if (clientes.isEmpty()) {
            inicializarClientes();
            serializarClientes();
        }

        if (peliculas.isEmpty()) {
            inicializarPeliculas();
            serializarPeliculas();
        }
    }

    // Métodos de inicialización de clientes y películas

    private void inicializarClientes() {
        clientes.add(new Cliente(1, "11111111", "Juan Pérez"));
        clientes.add(new Cliente(2, "22222222", "María López"));
        clientes.add(new Cliente(3, "33333333", "Pedro Rodríguez"));
        clientes.add(new Cliente(4, "44444444", "Ana Sánchez"));
        clientes.add(new Cliente(5, "55555555", "Luis González"));
        clientes.add(new Cliente(6, "66666666", "Laura Fernández"));
        clientes.add(new Cliente(7, "77777777", "Carlos Martínez"));
        clientes.add(new Cliente(8, "88888888", "Sofía Ramírez"));
        clientes.add(new Cliente(9, "99999999", "Diego Torres"));
        clientes.add(new Cliente(10, "10101010", "Elena Pérez"));
    }

    private void inicializarPeliculas() {
        peliculas.add(new Pelicula("Pelicula 1"));
        peliculas.add(new Pelicula("Pelicula 2"));
        peliculas.add(new Pelicula("Pelicula 3"));
        peliculas.add(new Pelicula("Pelicula 4"));
        peliculas.add(new Pelicula("Pelicula 5"));
        peliculas.add(new Pelicula("Pelicula 6"));
        peliculas.add(new Pelicula("Pelicula 7"));
        peliculas.add(new Pelicula("Pelicula 8"));
        peliculas.add(new Pelicula("Pelicula 9"));
        peliculas.add(new Pelicula("Pelicula 10"));
    }

    public List<Cliente> serializarClientes() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(CLIENTES_JSON_PATH), clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public List<Pelicula> serializarPeliculas() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(PELICULAS_JSON_PATH), peliculas);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    public List<Cliente> cargarClientesDesdeJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(CLIENTES_JSON_PATH);
        if (file.exists()) {
            try {
                clientes = objectMapper.readValue(file, new TypeReference<List<Cliente>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return clientes;
    }

    public List<Pelicula> cargarPeliculasDesdeJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(PELICULAS_JSON_PATH);
        if (file.exists()) {
            try {
                peliculas = objectMapper.readValue(file, new TypeReference<List<Pelicula>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return peliculas;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        serializarClientes();
    }

    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        serializarPeliculas();
    }

    public List<Pelicula> obtenerPeliculas() {
        return peliculas;
    }
}
