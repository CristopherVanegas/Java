package com.example.sistemadeventas.controllers;

import com.example.sistemadeventas.models.Categoria;
import com.example.sistemadeventas.models.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaginaCompraProductosController {

    private List<Producto> productos;
    private List<Categoria> categorias;

    @FXML
    private TableView<Producto> tablaProductos;

    public PaginaCompraProductosController() {
        // Inicializa las listas de categorías y productos aquí
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Computadoras"));
        categorias.add(new Categoria(2, "Laptops"));
        categorias.add(new Categoria(3, "Tablets"));
        categorias.add(new Categoria(4, "Impresoras"));
        categorias.add(new Categoria(5, "Celulares"));
        categorias.add(new Categoria(6, "Audio"));
        categorias.add(new Categoria(7, "Video"));

        productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto 1", 500.0, categorias.get(0)));
        productos.add(new Producto(2, "Producto 2", 800.0, categorias.get(1)));
        // Agrega más productos si es necesario

        // Llama al método para guardar categorías y productos en archivos JSON
        ProductAndCategoryJSONController.guardarCategoriasYProductosEnJSON(categorias, productos);
    }

    @FXML
    private void initialize() {
        TableColumn<Producto, String> nombreColumna = new TableColumn<>("Nombre");
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombreColumna.prefWidthProperty().bind(tablaProductos.widthProperty().divide(3)); // Divide el ancho en 3
                                                                                          // columnas

        TableColumn<Producto, Double> precioColumna = new TableColumn<>("Precio");
        precioColumna.setCellValueFactory(new PropertyValueFactory<>("precio"));
        precioColumna.prefWidthProperty().bind(tablaProductos.widthProperty().divide(3)); // Divide el ancho en 3
                                                                                          // columnas

        TableColumn<Producto, String> categoriaColumna = new TableColumn<>("Categoría");
        categoriaColumna.setCellValueFactory(cellData -> cellData.getValue().getCategoria().nombreProperty());
        categoriaColumna.prefWidthProperty().bind(tablaProductos.widthProperty().divide(3)); // Divide el ancho en 3
                                                                                             // columnas

        // Centra el contenido de las celdas
        nombreColumna.setStyle("-fx-alignment: CENTER;");
        precioColumna.setStyle("-fx-alignment: CENTER;");
        categoriaColumna.setStyle("-fx-alignment: CENTER;");

        tablaProductos.getColumns().addAll(nombreColumna, precioColumna, categoriaColumna);
        tablaProductos.setItems(FXCollections.observableArrayList(productos));

        // Establece el ancho máximo de la tabla al ancho máximo de la ventana
        tablaProductos.setMaxWidth(Double.MAX_VALUE);
    }

    private void cargarCategoriasDesdeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File categoriasFile = new File(
                    "sistemadeventas/src/main/java/com/example/sistemadeventas/data/categorias.json");
            if (!categoriasFile.exists()) {
                System.err.println("El archivo de categorías no existe.");
                return;
            }

            System.out.println("Leyendo categorías desde el archivo JSON...");
            categorias = objectMapper.readValue(categoriasFile,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Categoria.class));
            System.out.println("Categorías cargadas exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar las categorías desde el archivo JSON: " + e.getMessage());
        }
    }

    private void cargarProductosDesdeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File productosFile = new File(
                    "sistemadeventas/src/main/java/com/example/sistemadeventas/data/productos.json");
            if (!productosFile.exists()) {
                System.err.println("El archivo de productos no existe.");
                return;
            }

            System.out.println("Leyendo productos desde el archivo JSON...");
            productos = objectMapper.readValue(productosFile,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Producto.class));
            System.out.println("Productos cargados exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar los productos desde el archivo JSON: " + e.getMessage());
        }
    }

    @FXML
    private void handleLogout() {
        try {
            File sessionFile = new File("sistemadeventas/src/main/java/com/example/sistemadeventas/data/session.json");
            if (sessionFile.exists()) {
                sessionFile.delete();
                System.out.println("Sesión cerrada correctamente.");
            } else {
                System.err.println("El archivo de sesión no existe.");
            }

            // Agrega aquí la importación adecuada para App
            com.example.sistemadeventas.view.App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cerrar sesión: " + e.getMessage());
        }
    }
}
