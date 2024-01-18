package com.example.sistemadeventas.controllers;

import java.io.IOException;
import java.util.List;

import com.example.sistemadeventas.models.DetalleDePedidoCarrito;
import com.example.sistemadeventas.models.Pedido;
import com.example.sistemadeventas.models.Producto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Date;

public class PaginaCarritoController {
    public PaginaCarritoController() {
        // Constructor sin argumentos
    }

    @FXML
    private TableView<Pedido> tablaCarrito;
    @FXML
    private TableColumn<Pedido, Integer> idPedidoColumna;
    @FXML
    private TableColumn<Pedido, String> clienteColumna;
    @FXML
    private TableColumn<Pedido, Date> fechaColumna;
    @FXML
    private TableColumn<Pedido, String> formaDeEnvioColumna;
    @FXML
    private TableColumn<Pedido, String> estadoDelPedidoColumna;

    private List<Pedido> pedidos;
    int idPedido;
    String getCliente;
    Date getFecha;
    String getFormaDeEnvio;
    String getEstadoDelPedido;

    @FXML
    private Button btnComprar;

    @FXML
private void initialize() {
    // Crear las columnas personalizadas
    TableColumn<Pedido, String> idPedidoColumna = new TableColumn<>("ID Pedido");
    idPedidoColumna.setCellValueFactory(new PropertyValueFactory<>("idPedido"));

    TableColumn<Pedido, String> clienteColumna = new TableColumn<>("Cliente");
    clienteColumna.setCellValueFactory(new PropertyValueFactory<>("cliente"));

    TableColumn<Pedido, Date> fechaColumna = new TableColumn<>("Fecha");
    fechaColumna.setCellValueFactory(new PropertyValueFactory<>("fecha"));

    TableColumn<Pedido, String> formaDeEnvioColumna = new TableColumn<>("Forma de Envío");
    formaDeEnvioColumna.setCellValueFactory(new PropertyValueFactory<>("formaDeEnvio"));

    TableColumn<Pedido, String> estadoDelPedidoColumna = new TableColumn<>("Estado del Pedido");
    estadoDelPedidoColumna.setCellValueFactory(new PropertyValueFactory<>("estadoDelPedido"));

    // Establecer estilo de fuente para las celdas
    setFontStyleForTableColumn(idPedidoColumna);
    setFontStyleForTableColumn(clienteColumna);
    setFontStyleForTableColumn(fechaColumna);
    setFontStyleForTableColumn(formaDeEnvioColumna);
    setFontStyleForTableColumn(estadoDelPedidoColumna);

    // Agregar las columnas personalizadas a la tabla
    tablaCarrito.getColumns().addAll(idPedidoColumna, clienteColumna, fechaColumna, formaDeEnvioColumna, estadoDelPedidoColumna);

    // Cargar los datos de los pedidos desde tu controlador de JSON o donde los tengas
    pedidos = ProductAndCategoryJSONController.cargarPedidos();
    ObservableList<Pedido> listaPedidos = FXCollections.observableArrayList(pedidos);

    // Enlazar la lista a la tabla
    tablaCarrito.setItems(listaPedidos);
}

private void setFontStyleForTableColumn(TableColumn<?, ?> column) {
    // Crear un estilo de fuente y aplicarlo a la columna
    Font font = new Font("Arial", 16);
    column.setStyle("-fx-font-family: '" + font.getFamily() + "'; -fx-font-size: " + font.getSize() + "px;");
}


    private void debuggerGetPedidosMessage() {
        // Imprimir el contenido de pedidos por consola
        System.out.println("Contenido de pedidos:");
        for (Pedido pedido : pedidos) {
            idPedido = pedido.getIdPedido();
            getCliente = pedido.getCliente();
            getFecha = pedido.getFecha();
            getFormaDeEnvio = pedido.getFormaDeEnvio();
            getEstadoDelPedido = pedido.getEstadoDelPedido();

            System.out.println("ID: " + idPedido);
            System.out.println("Cliente: " + getCliente);
            System.out.println("Fecha: " + getFecha);
            System.out.println("Forma de Envío: " + getFormaDeEnvio);
            System.out.println("Estado del Pedido: " + getEstadoDelPedido);
            System.out.println("Detalle del Pedido:");
            DetalleDePedidoCarrito detalle = pedido.getDetalleDePedidoCarrito();
            System.out.println("Detalle del Pedido:");
            List<Producto> productos = detalle.getProductos();
            for (Producto producto : productos) {
                System.out.println("ID del Producto: " + producto.getId());
                System.out.println("Nombre del Producto: " + producto.getNombre());
                System.out.println("Precio del Producto: " + producto.getPrecio());
                System.out.println("Categoría del Producto: " + producto.getCategoria().getNombre()); // Si tienes una
                                                                                                      // propiedad
                                                                                                      // "nombre" en la
                                                                                                      // clase Categoria
                // Agrega aquí cualquier otra propiedad del producto que desees mostrar
                System.out.println("------------------------");
            }
            System.out.println("------------------------");
        }
    }

    @FXML
    private void handleComprar() {
        // Aquí debes implementar la lógica para cambiar el estado del pedido a
        // "cancelado"
        // Por ejemplo, puedes tener una función en tu modelo para actualizar el estado
        // del pedido
        // Luego, cierra la ventana actual del carrito
        Stage stage = (Stage) btnComprar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleGoBack() {
        // Establece como pagina root PaginaCarrito
        try {
            // Agrega aquí la importación adecuada para App
            com.example.sistemadeventas.view.App.setRoot("PaginaCompraProductos");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al acceder a PaginaCompraProductos: " + e.getMessage());
        }
    }
}