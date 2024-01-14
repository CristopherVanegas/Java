package com.example.jsonmanager;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App extends Application {

    private static final String FILE_PATH = "clientes.json";
    private List<Cliente> clientes;
    private JsonFileManager jsonFileManager;

    @Override
    public void start(Stage stage) {
        // Inicializar el array de clientes y el manejador JSON
        clientes = new ArrayList<>();
        jsonFileManager = new JsonFileManager(FILE_PATH);

        // Cargar clientes desde el archivo JSON (si existe)
        clientes = jsonFileManager.cargarClientes();

        // Interactuar con el usuario por consola
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Mostrar clientes");
            System.out.println("2. Agregar nuevo cliente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarClientes();
                    break;
                case 2:
                    agregarCliente(scanner);
                    break;
                case 3:
                    // Guardar el array actualizado en el archivo JSON antes de salir
                    jsonFileManager.guardarClientes(clientes);
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 3);
    }

    private void mostrarClientes() {
        System.out.println("Clientes registrados:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombres() + " " + cliente.getApellidos() +
                    " - Cédula/RUC: " + cliente.getCedulaRUC() +
                    " - Código Cliente: " + cliente.getCodigoCliente());
        }
    }

    private void agregarCliente(Scanner scanner) {
        System.out.print("Ingrese la cédula/RUC del nuevo cliente: ");
        String cedulaRUC = scanner.next();
        System.out.print("Ingrese los nombres del nuevo cliente: ");
        String nombres = scanner.next();
        System.out.print("Ingrese los apellidos del nuevo cliente: ");
        String apellidos = scanner.next();
        System.out.print("Ingrese el correo del nuevo cliente: ");
        String correo = scanner.next();
        System.out.print("Ingrese la dirección del nuevo cliente: ");
        String direccion = scanner.next();
        System.out.print("Ingrese el teléfono del nuevo cliente: ");
        String telefono = scanner.next();

        Cliente nuevoCliente = new Cliente(cedulaRUC, nombres, apellidos, correo, direccion, telefono);
        clientes.add(nuevoCliente);

        System.out.println("Cliente agregado correctamente.");
    }

    public static void main(String[] args) {
        launch();
    }
}
