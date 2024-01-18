package com.example.sistemadeventas.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.scene.control.TableCell;

import com.example.sistemadeventas.models.DetalleDePedidoCarrito;
import com.example.sistemadeventas.models.Pedido;
import com.example.sistemadeventas.models.Producto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PaginaCarritoController {
    private List<Pedido> pedidos = new ArrayList<>();

    @FXML
    private Button btnComprar;

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

    // Crear una columna personalizada para mostrar los detalles del pedido
    @FXML
    private TableColumn<Pedido, Void> detallesColumna;

    private ObservableList<Pedido> listaDePedidos = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Cargar los pedidos desde el archivo JSON
        pedidos = ProductAndCategoryJSONController.cargarPedidos();
        debuggerGetPedidosMessage();
        

        // Asignar la lista de pedidos a la tabla
        tablaCarrito.setItems(listaDePedidos);
    }
    

    private void debuggerGetPedidosMessage() {
        // Imprimir el contenido de pedidos por consola
        System.out.println("Contenido de pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println("ID: " + pedido.getIdPedido());
            System.out.println("Cliente: " + pedido.getCliente());
            System.out.println("Fecha: " + pedido.getFecha());
            System.out.println("Forma de Envío: " + pedido.getFormaDeEnvio());
            System.out.println("Estado del Pedido: " + pedido.getEstadoDelPedido());
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
