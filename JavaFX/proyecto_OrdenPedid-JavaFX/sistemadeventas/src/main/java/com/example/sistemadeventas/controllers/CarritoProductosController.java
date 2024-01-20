package com.example.sistemadeventas.controllers;

import com.example.sistemadeventas.models.DetalleDePedidoCarrito;
import com.example.sistemadeventas.models.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;

public class CarritoProductosController {
    @FXML
    private TableView<Producto> tablaProductos;
    @FXML
    private TableColumn<Producto, Integer> idColumna;
    @FXML
    private TableColumn<Producto, String> nombreColumna;
    @FXML
    private TableColumn<Producto, Double> precioColumna;

    public void inicializarCarrito(DetalleDePedidoCarrito carrito) {
        // Configura las columnas de la tabla
        idColumna.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        precioColumna.setCellValueFactory(new PropertyValueFactory<>("precio"));

        // Crea una lista observable de productos a partir del carrito
        ObservableList<Producto> listaProductos = FXCollections.observableArrayList(carrito.getProductos());

        // Enlaza la lista de productos a la tabla
        tablaProductos.setItems(listaProductos);

        // Ajusta el tamaño de las columnas de la tabla
        tablaProductos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Establece el estilo de fuente para las celdas
        setFontStyleForTableColumn(idColumna);
        setFontStyleForTableColumn(nombreColumna);
        setFontStyleForTableColumn(precioColumna);
    }

    private void setFontStyleForTableColumn(TableColumn<?, ?> column) {
        // Crea un estilo de fuente y aplícalo a la columna
        Font font = new Font("Arial", 14);
        column.setStyle("-fx-font-family: '" + font.getFamily() + "'; -fx-font-size: " + font.getSize() + "px;");
    }
}
