package com.example.examen.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ventaTickets.fxml"));
        Parent root = loader.load();

        // Crear una escena
        Scene scene = new Scene(root);

        // Configurar el escenario principal
        primaryStage.setTitle("Venta de Tickets"); // Cambia el título según tu preferencia
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
