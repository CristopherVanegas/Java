module com.example.prestamolibros {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.prestamolibros.controller to javafx.fxml;

    exports com.example.prestamolibros; // Puedes exportar todo el paquete principal si es necesario.
}
