package app.controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class ControllerBase implements ICambioDeScene {
    public void cambiarEscena(String fxmlFilePath, double width, double height, ActionEvent event) throws Exception {
        Pane root = javafx.fxml.FXMLLoader.load(java.util.Objects.requireNonNull(getClass().getResource(fxmlFilePath)));
        Stage stage = (javafx.stage.Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new javafx.scene.Scene(root, width, height);
        stage.setScene(scene);
        stage.show();
    }
}
