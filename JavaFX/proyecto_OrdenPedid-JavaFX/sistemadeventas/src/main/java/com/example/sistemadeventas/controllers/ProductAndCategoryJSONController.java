package com.example.sistemadeventas.controllers;

import com.example.sistemadeventas.models.Categoria;
import com.example.sistemadeventas.models.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductAndCategoryJSONController {

    private static final String CATEGORIAS_JSON_PATH = "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\data\\categorias.json";
    private static final String PRODUCTOS_JSON_PATH = "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\data\\productos.json";

    public static void guardarCategoriasYProductosEnJSON(List<Categoria> categorias, List<Producto> productos) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Serializa categorías a JSON y guárdalas en un archivo
            objectMapper.writeValue(new File(CATEGORIAS_JSON_PATH), categorias);

            // Serializa productos a JSON y guárdalos en un archivo
            objectMapper.writeValue(new File(PRODUCTOS_JSON_PATH), productos);

            System.out.println("Datos guardados en archivos JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Categoria> cargarCategoriasDesdeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserializa categorías desde un archivo JSON
            return objectMapper.readValue(
                    new File(CATEGORIAS_JSON_PATH),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Categoria.class));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<Producto> cargarProductosDesdeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserializa productos desde un archivo JSON
            return objectMapper.readValue(
                    new File(PRODUCTOS_JSON_PATH),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Producto.class));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
