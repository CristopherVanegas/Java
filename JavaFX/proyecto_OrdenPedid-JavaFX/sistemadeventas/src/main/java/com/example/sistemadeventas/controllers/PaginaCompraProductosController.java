package com.example.sistemadeventas.controllers;

import com.example.sistemadeventas.models.Categoria;
import com.example.sistemadeventas.models.Cliente;
import com.example.sistemadeventas.models.DetalleDePedidoCarrito;
import com.example.sistemadeventas.models.Pedido;
import com.example.sistemadeventas.models.Producto;
import com.example.sistemadeventas.models.SessionData;

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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaginaCompraProductosController {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private List<DetalleDePedidoCarrito> detalleDePedidoCarritos = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<Categoria> categorias = new ArrayList<>();
    private static List<Producto> carrito = new ArrayList<>(); // Lista para almacenar los productos del carrito
    private static SessionData sessionData = null;
    private static String cedulaRUCSession = null;

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
        // Inicializa sessionData
        sessionData = ProductAndCategoryJSONController.cargarSessionDataDesdeJSON();
        // Obtener el cedulaRUC de sessionData
        cedulaRUCSession = sessionData.getCedulaRUC();

        // Inicializa el carrito desde el JSON
        carrito = ProductAndCategoryJSONController.cargarCarritoDesdeJSON(); // Inicializa la lista del carrito

        // Inicializa los usuarios
        clientes = ProductAndCategoryJSONController.cargarClientes(); // Inicializa la lista del carrito

        // Inicializa las categorias
        categorias.add(new Categoria(1, "Computadoras"));
        categorias.add(new Categoria(2, "Laptops"));
        categorias.add(new Categoria(3, "Tablets"));
        categorias.add(new Categoria(4, "Impresoras"));
        categorias.add(new Categoria(5, "Celulares"));
        categorias.add(new Categoria(6, "Audio"));
        categorias.add(new Categoria(7, "Video"));

        // Inicializa productos
        productos.add(new Producto(1, "MacBook Pro ", 2000, categorias.get(1),
                "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\resource\\images\\laptop_product_icon.jpg"));

        productos.add(new Producto(productos.size() + 1, "iPhone 15", 1000, categorias.get(4),
                "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\resource\\images\\iPhone15.jpeg"));

        productos.add(new Producto(productos.size() + 1, "iPad Air", 600, categorias.get(2),
                "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\resource\\images\\iPadAirM1.jpg"));

        productos.add(new Producto(productos.size() + 1, "HP LaserJet Printer", 400, categorias.get(3),
                "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\resource\\images\\printer_product_icon.jpeg"));

        productos.add(new Producto(productos.size() + 1, "iPhone 13", 1000, categorias.get(4),
                "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\resource\\images\\iPhone13.jpg"));

        productos.add(new Producto(productos.size() + 1, "Bose QuietComfort Headphones", 350, categorias.get(5),
                "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\resource\\images\\bose_headphones.jpg"));

        productos.add(new Producto(productos.size() + 1, "Samsung 4K Smart TV", 800, categorias.get(6),
                "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\resource\\images\\tv_product_icon.jpg"));

        productos.add(new Producto(productos.size() + 1, "Dell XPS Laptop", 1500, categorias.get(1),
                "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\resource\\images\\dell_xps.jpg"));

        productos.add(new Producto(productos.size() + 1, "Google Pixel 6", 900, categorias.get(4),
                "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\resource\\images\\pixel6.jpeg"));

        // Llama al método para guardar categorías y productos en archivos JSON
        ProductAndCategoryJSONController.guardarCategoriasYProductosEnJSON(categorias, productos);
    }

    @FXML
    private void initialize() {
        // 1ra Columna Imagenes
        TableColumn<Producto, String> imagenColumna = new TableColumn<>("Imagen");
        imagenColumna.setCellValueFactory(new PropertyValueFactory<>("imagenPath"));
        imagenColumna.setMinWidth(100);
        imagenColumna.setMaxWidth(100);

        imagenColumna.setCellFactory(column -> {
            return new TableCell<Producto, String>() {
                final ImageView imageView = new ImageView();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        // Cargar la imagen desde la ruta
                        Image image = new Image(new File(item).toURI().toString());
                        imageView.setImage(image);
                        imageView.setFitWidth(100);
                        imageView.setFitHeight(100);
                        setGraphic(imageView);
                    }
                }
            };
        });

        // 2da Columna Precio
        TableColumn<Producto, String> nombreColumna = new TableColumn<>("Nombre");
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombreColumna.prefWidthProperty().bind(tablaProductos.widthProperty().divide(4)); // Divide el ancho en 4
                                                                                          // columnas
        // 3ra Columna Precio
        TableColumn<Producto, Double> precioColumna = new TableColumn<>("Precio");
        precioColumna.setCellValueFactory(new PropertyValueFactory<>("precio"));
        precioColumna.prefWidthProperty().bind(tablaProductos.widthProperty().divide(4)); // Divide el ancho en 4
                                                                                          // columnas
        // 4ta Columna Categoria
        TableColumn<Producto, String> categoriaColumna = new TableColumn<>("Categoría");
        categoriaColumna.setCellValueFactory(cellData -> cellData.getValue().getCategoria().nombreProperty());
        categoriaColumna.prefWidthProperty().bind(tablaProductos.widthProperty().divide(4)); // Divide el ancho en 4

        // 5ta Columna Carrito
        TableColumn<Producto, Button> agregarCarritoColumna = new TableColumn<>("Acción");
        agregarCarritoColumna
                .setCellValueFactory(cellData -> new SimpleObjectProperty<>(new Button("Agregar al carrito")));
        agregarCarritoColumna.prefWidthProperty().bind(tablaProductos.widthProperty().divide(4)); // Divide el ancho en

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
        });

        // Styles
        imagenColumna.setStyle("-fx-alignment: CENTER;");
        nombreColumna.setStyle("-fx-alignment: CENTER;");
        precioColumna.setStyle("-fx-alignment: CENTER;");
        categoriaColumna.setStyle("-fx-alignment: CENTER;");
        agregarCarritoColumna.setStyle("-fx-alignment: CENTER;");

        tablaProductos.getColumns().addAll(imagenColumna, nombreColumna, precioColumna, categoriaColumna,
                agregarCarritoColumna);
        tablaProductos.setItems(FXCollections.observableArrayList(productos));

        // Configurar la tabla para que se ajuste automáticamente al contenido
        tablaProductos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Configura combobox
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
            // Buscar un cliente con el mismo cedulaRUC en la lista de clientes
            Cliente clienteEncontrado = null;
            for (Cliente cliente : clientes) {
                if (cliente.getCedulaRUC().equals(cedulaRUCSession)) {
                    clienteEncontrado = cliente;
                    break; // Terminar el bucle una vez que se encuentre un cliente con el mismo cedulaRUC
                }
            }

            if (clienteEncontrado != null) {
                // Agregar el producto seleccionado al carrito
                carrito.add(productoSeleccionado);
                
                // Mostrar la alerta
                mostrarAlerta("Producto agregado al carrito: " + productoSeleccionado.getNombre());

                // Depuración: Imprimir el contenido del carrito
                System.out.println("Contenido del carrito:");
                for (Producto producto : carrito) {
                    System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre());
                }
                
                // Obtiene la fecha actual
                Calendar calendar = Calendar.getInstance();
                Date fechaActual = calendar.getTime();
                
                // Agrega en detallePedido el carrito
                detalleDePedidoCarritos.add(
                    new DetalleDePedidoCarrito(carrito)
                );

                // Depuración: Imprimir el contenido de pedidos
                System.out.println("Contenido de pedidos:");
                for (Pedido pedido : pedidos) {
                    System.out.println("ID: " + pedido.getIdPedido() + ", Nombre: " + pedido.getCliente());
                }

                // Agrega a la lista de pedidos el carrito con la fecha actual
                pedidos.add(
                    new Pedido(1000 + Integer.parseInt(cedulaRUCSession), 
                    clienteEncontrado.getNombres() + clienteEncontrado.getApellidos(),
                    fechaActual, 
                    "En linea", 
                    "no cancelado",
                    detalleDePedidoCarritos)
                );

                // Guardar el carrito en el archivo JSON
                ProductAndCategoryJSONController.guardarCarritoEnJSON(carrito);

                // Guardar la lista de pedidos en el archivo JSON
                ProductAndCategoryJSONController.guardarPedidos(pedidos);

            } else {
                // Si no se encuentra un cliente con el mismo cedulaRUC, mostrar un mensaje de
                // error o manejar la situación de otra manera.
                mostrarAlerta("No se encontró un cliente con el cedulaRUC correspondiente.");
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
