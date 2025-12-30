package app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class IniciarSesionController {
    @FXML
    public Label welcomeText;



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
