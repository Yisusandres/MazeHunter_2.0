package app.controller;

import app.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuJuegoController {
    public static Usuario usuario;

    @FXML
    private Label nombreUsuarioLabel;

    public MenuJuegoController() {
    }

    public void initialize() {
        if (usuario != null) {
            nombreUsuarioLabel.setText(usuario.getNombreUsuario());
        }
    }

    @FXML
    public void jugarNuevoLaberinto(ActionEvent event){

    }
    @FXML
    public void cargarLaberintoGuardado(ActionEvent event){

    }
    @FXML
    public void verEstadisticas(ActionEvent event){

    }
    @FXML
    public void seleccionarSkin(ActionEvent event){

    }

    @FXML
    public void onBackButton(ActionEvent event) throws IOException {
        VBox root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/app/menuInicial.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 350, 370);
        stage.setScene(scene);
        stage.show();
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        MenuJuegoController.usuario = usuario;
    }
}
