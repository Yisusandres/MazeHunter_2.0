package app.controller;

import app.model.GestionUsuario;
import app.model.usuarios.Usuario;
import app.repository.AlmacenDatos;
import app.repository.DatosJson;
import app.service.Encriptacion;
import app.service.ValidarRegex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
public class VerEstadisticasController extends ControllerBase{

    @FXML
    private Button backButton;
    @FXML private GridPane estadisticasGridPane;
    @FXML private Label usuarioLabel;

    @FXML
    void onBackButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuJuego.fxml", 500, 370, event);
    }
}
