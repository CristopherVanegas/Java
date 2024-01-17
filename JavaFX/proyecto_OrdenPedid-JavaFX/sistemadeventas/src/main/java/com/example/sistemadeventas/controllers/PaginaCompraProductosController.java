package com.example.sistemadeventas.controllers;

import com.example.sistemadeventas.models.Categoria;
import com.example.sistemadeventas.models.Producto;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaginaCompraProductosController {

    private List<Producto> productos;
    private List<Categoria> categorias;
    private static List<Producto> carrito = new ArrayList<>(); // Lista para almacenar los productos del carrito

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private ComboBox<Categoria> comboBoxCategorias;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private StackPane alertPane;

    private Alert alert;

    public PaginaCompraProductosController() {
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Computadoras"));
        categorias.add(new Categoria(2, "Laptops"));
        categorias.add(new Categoria(3, "Tablets"));
        categorias.add(new Categoria(4, "Impresoras"));
        categorias.add(new Categoria(5, "Celulares"));
        categorias.add(new Categoria(6, "Audio"));
        categorias.add(new Categoria(7, "Video"));

        productos = new ArrayList<>();
        carrito = new ArrayList<>(); // Inicializa la lista del carrito

        // Genera al menos 30 productos con las categorías existentes
        for (int i = 1; i <= 30; i++) {
            Categoria categoria = categorias.get(i % categorias.size()); // Cicla a través de las categorías
            productos.add(new Producto(i, "Producto " + i, i * 100.0, categoria));
        }

        // Llama al método para guardar categorías y productos en archivos JSON
        ProductAndCategoryJSONController.guardarCategoriasYProductosEnJSON(categorias, productos);
    }

    @FXML
    private void initialize() {
        TableColumn<Producto, String> nombreColumna = new TableColumn<>("Nombre");
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombreColumna.prefWidthProperty().bind(tablaProductos.widthProperty().divide(4)); // Divide el ancho en 4
                                                                                          // columnas

        TableColumn<Producto, Double> precioColumna = new TableColumn<>("Precio");
        precioColumna.setCellValueFactory(new PropertyValueFactory<>("precio"));
        precioColumna.prefWidthProperty().bind(tablaProductos.widthProperty().divide(4)); // Divide el ancho en 4
                                                                                          // columnas

        TableColumn<Producto, String> categoriaColumna = new TableColumn<>("Categoría");
        categoriaColumna.setCellValueFactory(cellData -> cellData.getValue().getCategoria().nombreProperty());
        categoriaColumna.prefWidthProperty().bind(tablaProductos.widthProperty().divide(4)); // Divide el ancho en 4
                                                                                             // columnas

        TableColumn<Producto, Button> agregarCarritoColumna = new TableColumn<>("Acción");
        agregarCarritoColumna
                .setCellValueFactory(cellData -> new SimpleObjectProperty<>(new Button("Agregar al carrito")));
        agregarCarritoColumna.prefWidthProperty().bind(tablaProductos.widthProperty().divide(4)); // Divide el ancho en
                                                                                                  // 4 columnas

        agregarCarritoColumna.setCellFactory(column -> {
            return new TableCell<Producto, Button>() {
                final Button button = new Button("Agregar al carrito");

                {
                    button.setOnAction(event -> {
                        Producto producto = getTableView().getItems().get(getIndex());
                        agregarProductoAlCarrito(producto);
                    });
                }

                @Override
                protected void updateItem(Button item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(button);
                    }
                }
            };
        }); // 4 columnas

        nombreColumna.setStyle("-fx-alignment: CENTER;");
        precioColumna.setStyle("-fx-alignment: CENTER;");
        categoriaColumna.setStyle("-fx-alignment: CENTER;");
        agregarCarritoColumna.setStyle("-fx-alignment: CENTER;");

        tablaProductos.getColumns().addAll(nombreColumna, precioColumna, categoriaColumna, agregarCarritoColumna);
        tablaProductos.setItems(FXCollections.observableArrayList(productos));

        comboBoxCategorias.setItems(FXCollections.observableArrayList(categorias));
        comboBoxCategorias.getItems().add(0, new Categoria(0, "Todos"));
        comboBoxCategorias.setValue(comboBoxCategorias.getItems().get(0));

        comboBoxCategorias.setOnAction(event -> filtrarProductosPorCategoria());
    }

    @FXML
    private void filtrarProductosPorCategoria() {
        Categoria categoriaSeleccionada = comboBoxCategorias.getValue();
        if (categoriaSeleccionada == null || categoriaSeleccionada.getId() == 0) {
            tablaProductos.setItems(FXCollections.observableArrayList(productos));
        } else {
            List<Producto> productosFiltrados = productos.stream()
                    .filter(producto -> producto.getCategoria().equals(categoriaSeleccionada))
                    .collect(Collectors.toList());
            tablaProductos.setItems(FXCollections.observableArrayList(productosFiltrados));
        }
    }

    @FXML
    private void agregarProductoAlCarrito(Producto productoSeleccionado) {
        if (productoSeleccionado != null) {
            // Agregar el producto seleccionado al carrito
            carrito.add(productoSeleccionado);

            // Mostrar la alerta
            mostrarAlerta("Producto agregado al carrito: " + productoSeleccionado.getNombre());

            // Depuración: Imprimir el contenido del carrito
            System.out.println("Contenido del carrito:");
            for (Producto producto : carrito) {
                System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre());
            }
        }
    }

    private void mostrarAlerta(String mensaje) {
        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
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
