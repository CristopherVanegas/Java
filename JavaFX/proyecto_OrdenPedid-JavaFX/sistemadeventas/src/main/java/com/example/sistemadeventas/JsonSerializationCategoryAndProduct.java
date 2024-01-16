package com.example.sistemadeventas;

import com.example.sistemadeventas.models.Categoria;
import com.example.sistemadeventas.models.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonSerializationCategoryAndProduct {
    public static void main(String[] args) {
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Computadoras"));
        categorias.add(new Categoria(2, "Laptops"));
        categorias.add(new Categoria(3, "Tablets"));
        categorias.add(new Categoria(4, "Impresoras"));
        categorias.add(new Categoria(5, "Celulares"));
        categorias.add(new Categoria(6, "Audio"));
        categorias.add(new Categoria(7, "Video"));

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto 1", 500.0, categorias.get(0)));
        productos.add(new Producto(2, "Producto 2", 800.0, categorias.get(1)));
        // Agrega más productos si es necesario

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Serializa categorías a JSON y guárdalas en un archivo
            objectMapper.writeValue(
                    new File("sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\data\\categorias.json"),
                    categorias);

            // Serializa productos a JSON y guárdalos en un archivo
            objectMapper.writeValue(
                    new File("sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\data\\productos.json"),
                    productos);

            System.out.println("Datos guardados en archivos JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
