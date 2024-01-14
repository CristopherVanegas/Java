package com.example.sistemadeventas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import com.example.sistemadeventas.view.App;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Lógica de autenticación aquí
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @FXML
    private void handleRegister() throws IOException {
        // Navegar a la pantalla de registro
        App.setRoot("registroUsuarios");
    }
}
