package com.example.prestamolibros.controller;

import com.example.prestamolibros.models.Libro;
import com.example.prestamolibros.models.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Text fechaActualText;

    private int numeroLibrosAgregados = 0;
    private double subtotal = 0.0;
    private boolean aplicarDescuento = false;

    private List<Usuario> usuarios = new ArrayList<>(); // Declarar la lista de usuarios
    private List<Libro> estanteGlobal = new ArrayList<>();
    private Usuario usuario;

    @FXML
    private void consultarLibro() {
        String codigoLibro = codigoLibroTextField.getText(); // Obtener el código del libro ingresado

        // Buscar el libro por código en la lista estanteGlobal
        for (Libro libro : estanteGlobal) {
            if (String.valueOf(libro.getCodigoNum()).equals(codigoLibro)) {
                // Si se encuentra el libro, llenar los datos en los Text correspondientes
                nombresText.setText("Título: " + libro.getTitulo());
                numeroPaginasText.setText("Número de Páginas: " + libro.getNumeroDePaginas());
                costoText.setText("Costo: " + libro.getCosto());
                codigoText.setText("Código: " + libro.getCodigoNum());
                autorText.setText("Autor: " + libro.getAutor());
                return; // Salir del bucle una vez encontrado el libro
            }
        }

        // Si no se encuentra el libro, mostrar un mensaje de error
        nombresText.setText("Libro no encontrado");
        numeroPaginasText.setText("");
        costoText.setText("");
        codigoText.setText("");
        autorText.setText("");
    }

    @FXML
    private void consultarCliente() {
        String codigoCliente = codigoClienteTextField.getText(); // Obtener el código de cliente ingresado

        // Buscar al usuario por código en la lista de usuarios
        for (Usuario u : usuarios) {
            if (String.valueOf(u.getCodigoNum()).equals(codigoCliente)) {
                // Si se encuentra el usuario, establecer su nombre completo en el Text
                clienteText.setText("Cliente: " + u.getNombreCompleto());
                usuario = u; // Guardar la referencia al usuario
                return; // Salir del bucle una vez encontrado el usuario
            }
        }

        // Si no se encuentra el usuario, mostrar un mensaje de error
        clienteText.setText("Cliente no encontrado");
        usuario = null; // Establecer usuario como nulo
    }

    @FXML
    private void initialize() {
        // Este método se ejecutará cuando se inicialice el controlador
        // Puedes realizar configuraciones adicionales aquí si es necesario

        // Obtener la fecha actual
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = sdf.format(new Date());

        // Establecer la fecha actual en el Text
        fechaActualText.setText("Fecha Actual: " + fechaActual);

        // Crear un usuario con código y nombre (ajusta los valores según sea necesario)
        // Inicializar la lista de usuarios
        usuarios.add(new Usuario(1, "Nombre Usuario 1"));
        usuarios.add(new Usuario(2, "Nombre Usuario 2"));
        usuarios.add(new Usuario(3, "Nombre Usuario 3"));
        usuarios.add(new Usuario(4, "Nombre Usuario 4"));
        usuarios.add(new Usuario(5, "Nombre Usuario 5"));
        // Crear e inicializar 5 libros y agregarlos al estante global
        estanteGlobal.add(new Libro(1, "Libro 1", "Autor 1", 20.0, 200));
        estanteGlobal.add(new Libro(2, "Libro 2", "Autor 2", 25.0, 250));
        estanteGlobal.add(new Libro(3, "Libro 3", "Autor 3", 30.0, 300));
        estanteGlobal.add(new Libro(4, "Libro 4", "Autor 4", 35.0, 350));
        estanteGlobal.add(new Libro(5, "Libro 5", "Autor 5", 40.0, 400));

        // Establecer la fecha actual en el Text
        fechaActualText.setText("Fecha Actual: " + fechaActual);
    }

    @FXML
    private void agregarLibro() {
        // Aquí debes agregar la lógica para calcular subtotal, descuento, IVA y total a
        // pagar

        // Obtener el costo del libro desde el costoText y convertirlo a double
        double costoLibro = Double.parseDouble(costoText.getText());

        // Crear un libro con los valores necesarios (ajusta los valores según sea
        // necesario)
        Libro libro = new Libro(1, "Título del Libro", "Autor del Libro", costoLibro, 300);

        // Agregar el libro a la colección de libros del usuario
        boolean libroAgregado = usuario.agregarLibro(libro);

        if (libroAgregado) {
            // Incrementar el contador de libros agregados
            numeroLibrosAgregados++;

            // Calcular el precio de préstamo (5% del costo del libro)
            double precioPrestamo = costoLibro * 0.05;

            // Verificar si se aplica el descuento (más de tres libros)
            if (numeroLibrosAgregados > 3) {
                aplicarDescuento = true;
            }

            // Calcular subtotal (acumular el costo del libro)
            subtotal += costoLibro;

            // Calcular descuento (10% del subtotal si aplica)
            double descuento = aplicarDescuento ? subtotal * 0.10 : 0.0;

            // Calcular IVA (12% del subtotal)
            double iva = subtotal * 0.12;

            // Calcular total a pagar (subtotal - descuento + IVA)
            double totalPagar = subtotal - descuento + iva;

            // Actualizar los Text correspondientes
            totalLibrosText.setText("TotalLibros: " + numeroLibrosAgregados);
            subtotalText.setText("Subtotal: " + subtotal);
            descuentoText.setText("Descuento: " + descuento);
            ivaText.setText("I.V.A: " + iva);
            totalPagarText.setText("Total a Pagar: " + totalPagar);
        } else {
            // Mostrar un mensaje si el usuario intenta agregar más de 5 libros
            // Aquí puedes agregar la lógica para manejar este caso
        }
    }
}
