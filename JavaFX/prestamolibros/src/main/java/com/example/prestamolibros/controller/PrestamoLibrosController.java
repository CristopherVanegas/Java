package com.example.prestamolibros.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrestamoLibrosController {

    @FXML
    private TextField codigoClienteTextField;

    @FXML
    private Button consultarClienteButton;

    @FXML
    private Text clienteText;

    @FXML
    private TextField codigoLibroTextField;

    @FXML
    private Button consultarLibroButton;

    @FXML
    private Text nombresText;

    @FXML
    private Text numeroPaginasText;

    @FXML
    private Text costoText;

    @FXML
    private Text codigoText;

    @FXML
    private Text autorText;

    @FXML
    private Button agregarLibroButton;

    @FXML
    private Text totalLibrosText;

    @FXML
    private Text subtotalText;

    @FXML
    private Text descuentoText;

    @FXML
    private Text ivaText;

    @FXML
    private Text totalPagarText;

    @FXML
    private Text fechaActualText; // Agregamos un Text para mostrar la fecha actual

    @FXML
    private void initialize() {
        // Este método se ejecutará cuando se inicialice el controlador
        // Puedes realizar configuraciones adicionales aquí si es necesario

        // Obtener la fecha actual
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = sdf.format(new Date());

        // Establecer la fecha actual en el Text
        fechaActualText.setText("Fecha Actual: " + fechaActual);
    }
}
