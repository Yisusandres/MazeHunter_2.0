package app.controller;

import app.model.GestorLaberinto;
import app.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import laberinto.celdas.GestorImagenes;

import java.io.IOException;
import java.util.Objects;

public class MenuJuegoController extends ControllerBase{
    static Usuario usuario = GestorLaberinto.getJugador();
    @FXML
    private Label nombreUsuarioLabel;

    public MenuJuegoController() {
    }

    public void initialize() {
        if (usuario != null) {
            nombreUsuarioLabel.setText(usuario.getNombreUsuario());
        }
        GestorImagenes.setRutaPersonaje("/imagenes/personajes/personajeThomas.png");
    }

    @FXML
    public void jugarNuevoLaberinto(ActionEvent event) throws Exception {
        cambiarEscena("/app/laberintoNuevo.fxml", 380, 300, event);
    }
    @FXML
    public void cargarLaberintoGuardado(ActionEvent event){

    }
    @FXML
    public void verEstadisticas(ActionEvent event) throws Exception {
        cambiarEscena("/app/verEstadisticas.fxml", 350, 370, event);

    }
    @FXML
    public void seleccionarSkin(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuInicial.fxml", 350, 370, event);
    }

    @FXML
    public void onBackButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuInicial.fxml", 350, 370, event);
    }
    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        MenuJuegoController.usuario = usuario;
    }
}
