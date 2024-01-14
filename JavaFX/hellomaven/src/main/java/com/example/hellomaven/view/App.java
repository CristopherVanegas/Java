// App.java
package com.example.hellomaven.view;

import com.example.hellomaven.controller.TareasController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private TareasController tareasController;

    public static void main(String[] args) {
        launch(args);
    }

    private void cargarTareas() {
        try {
            tareasController.cargarTareas();
            System.out.println("Tareas cargadas correctamente");
        } catch (Exception e) {
            System.err.println("Error al cargar las tareas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void guardarTareas() {
        try {
            tareasController.guardarTareas();
            System.out.println("Tareas guardadas correctamente");
        } catch (Exception e) {
            System.err.println("Error al guardar las tareas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("App.fxml"));
            Parent root = loader.load();

            AppController appController = loader.getController();
            tareasController = new TareasController();
            appController.setTareasController(tareasController);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Lista de Tareas");
            primaryStage.show();

            cargarTareas(); // Asegúrate de que esta línea esté presente y se ejecute
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        // Guardar tareas en el archivo al cerrar la aplicación
        guardarTareas();
        System.exit(0);
    }
}
