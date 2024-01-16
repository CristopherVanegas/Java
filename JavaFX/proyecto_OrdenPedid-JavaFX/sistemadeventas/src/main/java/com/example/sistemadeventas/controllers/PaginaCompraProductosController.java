package com.example.sistemadeventas.controllers;

import javafx.fxml.FXML;

import java.io.IOException;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.sistemadeventas.view.App;

public class PaginaCompraProductosController {

    @FXML
    private void handleLogout() {
        // Lógica para cerrar sesión aquí
        // Por ejemplo, puedes navegar de regreso a la pantalla de inicio de sesión
        try {
            App.setRoot("login");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Asume que "login" es el nombre de tu archivo FXML de inicio de sesión
    }

    // Otros métodos y lógica de tu controlador...
}
