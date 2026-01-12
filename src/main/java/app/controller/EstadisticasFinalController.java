package app.controller;

import app.model.GestorLaberinto;
import app.model.Jugador;
import app.model.usuarios.GuardadoPartida;
import app.model.usuarios.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EstadisticasFinalController extends ControllerBase{
    @FXML
    public Button continuarButton;
    @FXML
    private Label bombasObtenidas;

    @FXML
    private Label cristalesRecolectados;

    @FXML
    private Label energiaRestante;

    @FXML
    private GridPane estadisticasGridPane;

    @FXML
    private Label mensajeLabel;
    @FXML
    private Label vidaRestante;

    @FXML
    public void onContinuarButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuJuego.fxml", 380, 340, event);
    }

    private static Jugador jugador;

    public void initialize() {
        Jugador jugadorParaEstadisticas = jugador;
        System.out.println(jugadorParaEstadisticas.getVida());
        System.out.println(jugadorParaEstadisticas.getCristales());
        System.out.println(jugadorParaEstadisticas.getBombas());
        System.out.println(jugadorParaEstadisticas.getEnergia());

        vidaRestante.setText(String.valueOf(jugadorParaEstadisticas.getVida()));
        cristalesRecolectados.setText(String.valueOf(jugadorParaEstadisticas.getCristales()));
        bombasObtenidas.setText(String.valueOf(jugadorParaEstadisticas.getBombas()));
        energiaRestante.setText(String.valueOf(jugadorParaEstadisticas.getEnergia()));

        if (GestorLaberinto.isHaPerdido()) {
            mensajeLabel.setText("PERDISTE");
            mensajeLabel.setTextFill(javafx.scene.paint.Color.RED);
        } else {
            mensajeLabel.setText("FELICIDADES");
            mensajeLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        }
    }

    public static void setJugadorParaEstadisticas(Jugador jugadorParaEstadisticas) {
        EstadisticasFinalController.jugador = jugadorParaEstadisticas;
    }
}
