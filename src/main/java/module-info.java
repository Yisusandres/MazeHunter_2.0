module com.view.mazehunterapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires jdk.jfr;

    opens app.controller to javafx.fxml;
    exports app.controller;
    opens app to javafx.fxml;
    opens app.model to com.fasterxml.jackson.databind;
    exports app.model;
    exports app;
    exports app.model.usuarios;
    opens app.model.usuarios to com.fasterxml.jackson.databind;

}