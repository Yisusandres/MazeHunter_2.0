package app.controller;

import app.model.GestorLaberinto;
import app.model.Jugador;
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
    private Label trampasActivadas;

    @FXML
    private Label vidaRestante;

    @FXML
    private Label vidasExtraObtenidas;

    @FXML
    public void onContinuarButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuJuego.fxml", 380, 340, event);
    }

    public void initialize() {
        Jugador jugadorParaEstadisticas = GestorLaberinto.getJugador();
        System.out.println(jugadorParaEstadisticas.getVida());
        System.out.println(jugadorParaEstadisticas.getCristales());
        System.out.println(jugadorParaEstadisticas.getBombas());
        System.out.println(jugadorParaEstadisticas.getEnergia());

        vidaRestante.setText(String.valueOf(jugadorParaEstadisticas.getVida()));
        cristalesRecolectados.setText(String.valueOf(jugadorParaEstadisticas.getCristales()));
        vidasExtraObtenidas.setText(String.valueOf("0"));
        trampasActivadas.setText("0");
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
}
