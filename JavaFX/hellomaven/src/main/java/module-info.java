module com.example.hellomaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens com.example.hellomaven.view to javafx.fxml;

    exports com.example.hellomaven.model;
    exports com.example.hellomaven.controller;
    exports com.example.hellomaven.view;
}
