module com.example.sistemadeventas {
    requires com.fasterxml.jackson.databind;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.sistemadeventas.view to javafx.fxml;
    opens com.example.sistemadeventas.controllers to javafx.fxml;
    
    exports com.example.sistemadeventas.view;
    exports com.example.sistemadeventas.models;
    exports com.example.sistemadeventas.controllers;
}
