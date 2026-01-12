package app.controller;

import app.model.GestionUsuario;
import app.model.GestorLaberinto;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
public class VerEstadisticasController extends ControllerBase {

    @FXML private Button backButton;
    @FXML private GridPane estadisticasGridPane;
    @FXML private Label usuarioLabel;
    @FXML private Label bombasRecolectadas;
    @FXML private Label cristalesRecolectados;
    @FXML private Label laberintosGanados;
    @FXML private Label laberintosJugados;
    @FXML private Label laberintosPerdidos;
    @FXML private Label trampasActivadas;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @FXML
    void onBackButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuJuego.fxml", 380, 340, event);
    }

    /**
     * Inicializar verEstadisticas.fxml
     * * @author Darwin Marcano
     * @version 22.0.2
     * @since 11-01-2026
     */
    public void initialize(){
        usuario = GestorLaberinto.getUsuarioActivo();
        usuarioLabel.setText(usuario.getNombreUsuario());

        laberintosGanados.setText(String.valueOf(usuario.getPartidasGanadas()));
        laberintosPerdidos.setText(String.valueOf(usuario.getPartidasPerdidas()));
        laberintosJugados.setText(String.valueOf(usuario.getLaberintosJugados()));
        cristalesRecolectados.setText(String.valueOf(usuario.getCristalesObtenidos()));
        bombasRecolectadas.setText(String.valueOf(usuario.getBombasRecolectadas()));
        trampasActivadas.setText(String.valueOf(usuario.getTrampasActivadas()));
    }
}
