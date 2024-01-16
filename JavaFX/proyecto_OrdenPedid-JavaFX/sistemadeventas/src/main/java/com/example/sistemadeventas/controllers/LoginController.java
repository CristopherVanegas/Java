package com.example.sistemadeventas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.example.sistemadeventas.models.Cliente;
import com.example.sistemadeventas.view.App;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private List<Cliente> clientes; // Lista de clientes cargada desde el archivo JSON

    // Constructor
    public LoginController() {
        // Inicializa la lista de clientes desde el archivo JSON
        clientes = cargarClientesDesdeJSON(); // Debes implementar esta función
    }

    @FXML
    private void handleLogin() {
        if (clientes == null) {
            // La carga de clientes falló, muestra un mensaje de error
            System.err.println("Error al cargar clientes desde el archivo JSON.");
            return;
        }

        String username = usernameField.getText();
        String password = passwordField.getText();

        // Lógica de autenticación aquí
        for (Cliente cliente : clientes) {
            if (cliente.getCedulaRUC().equals(username) && cliente.getCedulaRUC().equals(password)) {
                System.out.println("Sesión exitosa");
                try {
                    // Cambiar a la pantalla de compra de productos
                    App.setRoot("PaginaCompraProductos");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Error al cambiar a la pantalla de compra de productos: " + e.getMessage());
                }
                return;
            }
        }

        System.out.println("Credenciales incorrectas");
    }

    @FXML
    private void handleRegister() throws IOException {
        // Navegar a la pantalla de registro
        App.setRoot("registroUsuarios");
    }

    // Función para cargar clientes desde el archivo JSON
    private List<Cliente> cargarClientesDesdeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File jsonFile = new File("src/main/java/com/example/sistemadeventas/data/clientes.json"); // Ruta al archivo
                                                                                                      // JSON de
                                                                                                      // clientes
            if (jsonFile.exists()) {
                return objectMapper.readValue(jsonFile, new TypeReference<List<Cliente>>() {
                });
            } else {
                System.err.println("El archivo JSON de clientes no existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar datos desde el archivo JSON de clientes: " + e.getMessage());
        }
        return null; // Devuelve null si la carga falla
    }
}
