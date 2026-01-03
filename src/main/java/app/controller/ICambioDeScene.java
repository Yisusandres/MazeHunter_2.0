package app.controller;
import javafx.event.ActionEvent;

public interface ICambioDeScene {
    void cambiarEscena(String fxmlFilePath, double width, double height, ActionEvent event) throws Exception;
}
