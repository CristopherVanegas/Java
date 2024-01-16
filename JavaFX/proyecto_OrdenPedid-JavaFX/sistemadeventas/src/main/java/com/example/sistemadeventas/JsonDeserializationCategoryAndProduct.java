package com.example.sistemadeventas;

import com.example.sistemadeventas.models.Categoria;
import com.example.sistemadeventas.models.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class JsonDeserializationCategoryAndProduct {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserializa categorías desde un archivo JSON
            List<Categoria> categorias = objectMapper.readValue(
                    new File("sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\data\\categorias.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Categoria.class));

            // Deserializa productos desde un archivo JSON
            List<Producto> productos = objectMapper.readValue(
                    new File("sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\data\\productos.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Producto.class));

            // Ahora tienes tus listas de categorías y productos cargadas desde los archivos
            // JSON
            System.out.println("Categorías cargadas desde JSON:");
            for (Categoria categoria : categorias) {
                System.out.println(categoria.getId() + " - " + categoria.getNombre());
            }

            System.out.println("Productos cargados desde JSON:");
            for (Producto producto : productos) {
                System.out.println(producto.getId() + " - " + producto.getNombre() + " - " + producto.getPrecio());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}