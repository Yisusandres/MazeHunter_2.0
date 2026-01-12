package app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuInicialController extends ControllerBase {
    @FXML
    private void onIniciarSesion(ActionEvent event) throws Exception {
        cambiarEscena("/app/iniciarSesion.fxml", 520, 370, event);
    }

    @FXML
    private void onRegistrar(ActionEvent event) throws Exception {
        cambiarEscena("/app/registrar.fxml", 520, 370, event);
    }

    /**
     * Cerrar juego
     * * @author Darwin Marcano
     * @version 22.0.2
     * @since 11-01-2026
     */
    @FXML
    private void onSalir() {
        System.exit(0);
    }

}
