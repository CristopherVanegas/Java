package com.example.sistemadeventas.controllers;

import javafx.fxml.FXML;

import java.io.File;
import java.io.IOException;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.sistemadeventas.view.App;

public class PaginaCompraProductosController {

    @FXML
    private void handleLogout() {
        // Lógica para cerrar sesión aquí
        // Por ejemplo, puedes navegar de regreso a la pantalla de inicio de sesión
        try {
            // Eliminar el archivo de sesión si existe
            File sessionFile = new File(
                    "sistemadeventas\\src\\main\\java\\com\\example\\sistemadeventas\\data\\session.json");
            if (sessionFile.exists()) {
                sessionFile.delete();
            }

            // Cambiar a la pantalla de inicio de sesión
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cerrar sesión: " + e.getMessage());
        }
    }
    // Otros métodos y lógica de tu controlador...
}
