package app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class EstadisticasFinalController extends ControllerBase {

    @FXML
    private Button backButton;
    @FXML private GridPane estadisticasGridPane;
    @FXML private Label usuarioLabel;

    @FXML
    void onBackButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuJuego.fxml", 500, 370, event);
    }
}
