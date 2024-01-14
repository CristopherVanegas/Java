package com.example.hellomaven.view;

import java.util.List;

import com.example.hellomaven.controller.TareasController;
import com.example.hellomaven.model.Tarea;
import com.example.hellomaven.util.PersistenceUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppController {
    private TareasController tareasController;

    @FXML
    private TextField tareaTextField;

    @FXML
    private ListView<Tarea> tareasListView;

    @FXML
    private Button completarButton;

    @FXML
    private Button eliminarButton;

    @FXML
    private void agregarTarea() {
        String nombreTarea = tareaTextField.getText().trim();

        if (!nombreTarea.isEmpty() && tareasController != null) {
            Tarea nuevaTarea = new Tarea(nombreTarea, false);
            tareasController.agregarTarea(nuevaTarea);
            actualizarVista();
            tareaTextField.clear();
        }
    }

    @FXML
    private void completarTarea() {
        int indiceSeleccionado = tareasListView.getSelectionModel().getSelectedIndex();
        tareasController.marcarTareaComoCompletada(indiceSeleccionado);
        actualizarVista();
    }

    @FXML
    private void eliminarTarea() {
        Tarea tareaSeleccionada = tareasListView.getSelectionModel().getSelectedItem();
        if (tareaSeleccionada != null) {
            tareasController.eliminarTarea(tareaSeleccionada);
            actualizarVista();
        }
    }

    private void actualizarVista() {
        tareasListView.getItems().setAll(tareasController.getListaTareas());
    }

    public void setTareasController(TareasController tareasController) {
        this.tareasController = tareasController;
        cargarTareas(); // Cargar las tareas al inicio
        actualizarVista(); // Actualizar la lista al inicio
    }

    private void cargarTareas() {
        List<Tarea> tareasCargadas = PersistenceUtil.cargarTareas();

        if (tareasCargadas != null && !tareasCargadas.isEmpty()) {
            tareasController.setListaTareas(tareasCargadas);
            System.out.println("Tareas cargadas correctamente");
        } else {
            System.out.println("No se encontraron tareas almacenadas.");
        }
    }
}
