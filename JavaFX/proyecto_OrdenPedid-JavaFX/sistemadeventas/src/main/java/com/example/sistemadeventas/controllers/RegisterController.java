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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;

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

    // Listas para almacenar clientes, minoristas y mayoristas
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<ClienteMinorista> listaMinoristas = new ArrayList<>();
    private List<ClienteMayorista> listaMayoristas = new ArrayList<>();

    private static final String CLIENTES_JSON_PATH = "sistemadeventas/src/main/java/com/example/sistemadeventas/data/clientes.json";
    private static final String MAYORISTAS_JSON_PATH = "sistemadeventas/src/main/java/com/example/sistemadeventas/data/mayoristas.json";
    private static final String MINORISTAS_JSON_PATH = "sistemadeventas/src/main/java/com/example/sistemadeventas/data/minoristas.json";

    @FXML
    private void initialize() {
        tipoClienteToggleGroup = new ToggleGroup();
        minoristaRadio.setToggleGroup(tipoClienteToggleGroup);
        mayoristaRadio.setToggleGroup(tipoClienteToggleGroup);

        // Leer datos existentes de los archivos y cargar las listas
        listaClientes = leerClientesDesdeArchivo(CLIENTES_JSON_PATH, Cliente.class);
        listaMinoristas = leerClientesDesdeArchivo(MINORISTAS_JSON_PATH, ClienteMinorista.class);
        listaMayoristas = leerClientesDesdeArchivo(MAYORISTAS_JSON_PATH, ClienteMayorista.class);
    }

    @FXML
    private void handleRegister() throws IOException {
        if (camposLlenos() && tipoClienteSeleccionado()) {
            String cedulaRUC = cedulaRUCField.getText();

            // Verificar si el cliente ya existe
            if (clienteYaExiste(cedulaRUC)) {
                mostrarError("El cliente con el mismo Cédula/RUC ya está registrado.");
                return;
            }

            String nombres = nombresField.getText();
            String apellidos = apellidosField.getText();
            String correo = correoField.getText();
            String direccion = direccionField.getText();
            String telefono = telefonoField.getText();

            String tipoCliente = minoristaRadio.isSelected() ? "Minorista" : "Mayorista";

            // Crear objeto Cliente, ClienteMayorista o ClienteMinorista según el tipo
            Cliente clienteGeneral;
            if ("Mayorista".equals(tipoCliente)) {
                ClienteMayorista mayorista = new ClienteMayorista(cedulaRUC, nombres, apellidos, correo, direccion,
                        telefono, "Persona de Contacto");
                listaMayoristas.add(mayorista);
                clienteGeneral = mayorista;
            } else {
                ClienteMinorista minorista = new ClienteMinorista(cedulaRUC, nombres, apellidos, correo, direccion,
                        telefono, 0);
                listaMinoristas.add(minorista);
                clienteGeneral = minorista;
            }

            // Agregar el nuevo cliente a la lista general
            listaClientes.add(clienteGeneral);

            // Agregar el nuevo cliente a la lista específica (minoristas o mayoristas)
            if ("Mayorista".equals(tipoCliente)) {
                listaMayoristas.add((ClienteMayorista) clienteGeneral);
            } else {
                listaMinoristas.add((ClienteMinorista) clienteGeneral);
            }

            // Guardar en el archivo correspondiente (lista específica)
            if ("Mayorista".equals(tipoCliente)) {
                guardarClienteEnArchivo(clienteGeneral, MAYORISTAS_JSON_PATH, listaMayoristas);
            } else {
                guardarClienteEnArchivo(clienteGeneral, MINORISTAS_JSON_PATH, listaMinoristas);
            }

            // Guardar en el archivo de clientes generales
            guardarClienteEnArchivo(clienteGeneral, CLIENTES_JSON_PATH, listaClientes);

            System.out.println("Cliente registrado con éxito");

            // Cambiar a la vista de inicio de sesión
            App.setRoot("login");
        } else {
            mostrarError("Por favor, llene todos los campos y seleccione el tipo de cliente");
        }
    }

    @FXML
    private void handleCancel() throws IOException {
        App.setRoot("login");
    }

    private <T> void guardarClienteEnArchivo(Cliente cliente, String filePath, List<T> listaClientes) {
        // Método para guardar el cliente en el archivo
        try {
            File file = new File(filePath);

            // Guarda la lista específica en el archivo
            ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(file, listaClientes);

            System.out.println("Guardado con éxito en la ruta: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + filePath);
            e.printStackTrace();
        }
    }

    private <T> List<T> leerClientesDesdeArchivo(String filePath, Class<T> type) {
        // Método para leer clientes desde el archivo
        List<T> clientes = new ArrayList<>();

        try {
            File file = new File(filePath);

            // Verifica si el archivo existe antes de intentar leerlo
            if (file.exists()) {
                ObjectMapper objectMapper = new ObjectMapper();

                // Lee la lista de clientes desde el archivo
                CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, type);
                clientes = objectMapper.readValue(file, collectionType);

                System.out.println("Leído con éxito desde el archivo: " + filePath);
                System.out.println("Lista de clientes leídos:");
                clientes.forEach(System.out::println);
            } else {
                System.out.println("Archivo no encontrado: " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + filePath);
            e.printStackTrace();
        }

        return clientes;
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
    }

    private boolean clienteYaExiste(String cedulaRUC) {
        // Verificar si el cliente ya existe en la lista general
        return listaClientes.stream().anyMatch(cliente -> cliente.getCedulaRUC().equals(cedulaRUC));
    }
}
