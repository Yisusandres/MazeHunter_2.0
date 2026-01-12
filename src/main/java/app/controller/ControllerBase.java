package app.controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import laberinto.Posicion;

public class ControllerBase implements ICambioDeScene {
    /**
     * Cambiar escena predeterminado
     * * @author Darwin Marcano
     * @version 22.0.2
     * @since 11-01-2026
     * @param fxmlFilePath direccion del fxml.
     * @param width ancho de la ventana.
     * @param height altura de la ventana.
     * @param event al presionar.
     */
    public void cambiarEscena(String fxmlFilePath, double width, double height, ActionEvent event) throws Exception {
        Pane root = javafx.fxml.FXMLLoader.load(java.util.Objects.requireNonNull(getClass().getResource(fxmlFilePath)));
        Stage stage = (javafx.stage.Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new javafx.scene.Scene(root, width, height);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Cambiar escena para estadisticas final
     * * @author Darwin Marcano
     * @version 22.0.2
     * @since 11-01-2026
     * @param fxmlFilePath direccion del fxml.
     * @param width ancho de la ventana.
     * @param height altura de la ventana.
     * @param node a abrir.
     */
    public void cambiarEscenaDesdeNodo(String fxmlFilePath, double width, double height, javafx.scene.Node node) throws Exception {
        Pane root = javafx.fxml.FXMLLoader.load(java.util.Objects.requireNonNull(getClass().getResource(fxmlFilePath)));
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.show();
    }
}
