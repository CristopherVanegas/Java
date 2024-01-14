module com.example.jsonmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens com.example.jsonmanager to javafx.fxml;
    exports com.example.jsonmanager;
}
