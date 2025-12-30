package app.controller;

import app.service.BackgroundService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuInicialController {
    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private VBox rootVBox;

    @FXML
    private void onIniciarSesion(ActionEvent event) throws IOException {
        VBox root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/app/iniciarSesion.fxml")));
        BackgroundService.setBackgroundFill(rootVBox);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 640, 520);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onRegistrar(ActionEvent event) throws IOException {
        VBox root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/app/registrar.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 640, 520);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onSalir() {
        System.exit(0);
    }
}
