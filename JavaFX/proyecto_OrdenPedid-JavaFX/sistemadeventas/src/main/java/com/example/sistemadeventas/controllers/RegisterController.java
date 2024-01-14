package com.example.sistemadeventas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.sistemadeventas.models.Cliente;
import com.example.sistemadeventas.models.ClienteMayorista;
import com.example.sistemadeventas.models.ClienteMinorista;
import com.example.sistemadeventas.view.App;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class RegisterController {
    @FXML
    private TextField cedulaRUCField;

    @FXML
    private TextField nombresField;

    @FXML
    private TextField apellidosField;

    @FXML
    private TextField correoField;

    @FXML
    private TextField direccionField;

    @FXML
    private TextField telefonoField;

    @FXML
    private Label errorLabel;

    @FXML
    private RadioButton minoristaRadio;

    @FXML
    private RadioButton mayoristaRadio;

    private ToggleGroup tipoClienteToggleGroup;

    @FXML
    private void initialize() {
        tipoClienteToggleGroup = new ToggleGroup();
        minoristaRadio.setToggleGroup(tipoClienteToggleGroup);
        mayoristaRadio.setToggleGroup(tipoClienteToggleGroup);
    }

    private static final String CLIENTES_JSON_PATH = "src/main/java/com/example/sistemadeventas/data/clientes.json";
    private static final String MAYORISTAS_JSON_PATH = "src/main/java/com/example/sistemadeventas/data/mayoristas.json";
    private static final String MINORISTAS_JSON_PATH = "src/main/java/com/example/sistemadeventas/data/minoristas.json";

    @FXML
    private void handleRegister() throws IOException {
        if (camposLlenos() && tipoClienteSeleccionado()) {
            String cedulaRUC = cedulaRUCField.getText();
            String nombres = nombresField.getText();
            String apellidos = apellidosField.getText();
            String correo = correoField.getText();
            String direccion = direccionField.getText();
            String telefono = telefonoField.getText();

            String tipoCliente = minoristaRadio.isSelected() ? "Minorista" : "Mayorista";

            // Crear objeto Cliente, ClienteMayorista o ClienteMinorista según el tipo
            if ("Mayorista".equals(tipoCliente)) {
                ClienteMayorista mayorista = new ClienteMayorista(cedulaRUC, nombres, apellidos, correo, direccion,
                        telefono, "Persona de Contacto");
                guardarClienteEnArchivo(mayorista, MAYORISTAS_JSON_PATH);
            } else {
                ClienteMinorista minorista = new ClienteMinorista(cedulaRUC, nombres, apellidos, correo, direccion,
                        telefono, 0);
                guardarClienteEnArchivo(minorista, MINORISTAS_JSON_PATH);
            }

            // Guardar en el archivo clientes.json
            Cliente clienteGeneral = new Cliente(cedulaRUC, nombres, apellidos, correo, direccion, telefono);

            // Usar un identificador único basado en el timestamp
            String uniqueIdentifier = cedulaRUC + "_" + System.currentTimeMillis();
            clienteGeneral.setCodigoCliente(uniqueIdentifier);

            guardarClienteEnArchivo(clienteGeneral, CLIENTES_JSON_PATH);

            System.out.println("Cliente registrado con éxito");
            App.setRoot("login");
        } else {
            mostrarError("Por favor, llene todos los campos y seleccione el tipo de cliente");
        }
    }

    private void guardarClienteEnArchivo(Cliente cliente, String filePath) {
        try {
            // Lee los clientes existentes del archivo
            List<Cliente> clientesExistentes = leerClientesDesdeArchivo(filePath);

            // Agrega el nuevo cliente a la lista
            clientesExistentes.add(cliente);

            // Guarda la lista actualizada en el archivo
            ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filePath), clientesExistentes);

            System.out.println("Guardado con éxito en la ruta: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + filePath);
            e.printStackTrace();
        }
    }

    private List<Cliente> leerClientesDesdeArchivo(String filePath) {
        List<Cliente> clientes = new ArrayList<>();

        try {
            File file = new File(filePath);

            // Verifica si el archivo existe antes de intentar leerlo
            if (file.exists()) {
                ObjectMapper objectMapper = new ObjectMapper();

                // Lee la lista de clientes desde el archivo
                clientes = objectMapper.readValue(file, new TypeReference<List<Cliente>>() {
                });
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + filePath);
            e.printStackTrace();
        }

        return clientes;
    }

    @FXML
    private void handleCancel() throws IOException {
        App.setRoot("login");
    }

    private boolean camposLlenos() {
        return !cedulaRUCField.getText().isEmpty()
                && !nombresField.getText().isEmpty()
                && !apellidosField.getText().isEmpty()
                && !correoField.getText().isEmpty()
                && !direccionField.getText().isEmpty()
                && !telefonoField.getText().isEmpty();
    }

    private boolean tipoClienteSeleccionado() {
        return minoristaRadio.isSelected() || mayoristaRadio.isSelected();
    }

    private void mostrarError(String mensaje) {
        errorLabel.setText(mensaje);
        errorLabel.setStyle("-fx-text-fill: red;");
    }
}
