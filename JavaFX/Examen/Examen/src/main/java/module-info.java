module com.example.sistemadeventas {
    requires transitive javafx.base;
    requires com.fasterxml.jackson.databind;
    requires javafx.controls;
    requires javafx.fxml;
    
    opens com.example.examen.model to com.fasterxml.jackson.databind;
    opens com.example.examen.view to javafx.fxml;
    opens com.example.examen.controller to javafx.fxml;
    
    exports com.example.examen.view;
    exports com.example.examen.model;
    exports com.example.examen.controller;
}
