package com.example.examen.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import com.example.examen.controller.JsonManager;
import com.example.examen.model.Pelicula;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class VentaTicketsController implements Initializable {

    @FXML
    private Text txtNumero;

    @FXML
    private Text txtFecha;

    @FXML
    private TextField edtSala;

    @FXML
    private TextField edtPrecio;

    @FXML
    private TextField edtAsientos;

    @FXML
    private Text txtSubtotal;

    @FXML
    private Text txtIVA;

    @FXML
    private Text txtTotal;

    @FXML
    private ComboBox<String> comboBoxPelicula;

    @FXML
    private TextField txtCedula;

    @FXML
    private Text txtFullname;

    @FXML
    private Button btnBuscar;

    private JsonManager jsonManager;

    // Método que se ejecuta cuando se hace clic en el botón "Buscar"
    @FXML
    private void buscarCliente(ActionEvent event) {
        // Aquí puedes agregar la lógica para buscar al cliente según la cédula ingresada
        // y actualizar los campos de texto "txtCedula" y "txtFullname" con los datos del cliente.
        // Por ejemplo:
        // String cedula = txtCedula.getText();
        // Cliente cliente = buscarClientePorCedula(cedula);
        // if (cliente != null) {
        //     txtCedula.setText(cliente.getCedula());
        //     txtFullname.setText(cliente.getNombreCompleto());
        // }
    }

    // Método que se ejecuta al inicializar el controlador
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jsonManager = new JsonManager();
        List<Pelicula> peliculas = jsonManager.cargarPeliculasDesdeJson();

        // Llena el ComboBox con las películas cargadas desde JSON
        for (Pelicula pelicula : peliculas) {
            comboBoxPelicula.getItems().add(pelicula.getNombrePelicula());
        }
    }

    // Aquí puedes agregar más métodos y lógica según tus necesidades.
}
