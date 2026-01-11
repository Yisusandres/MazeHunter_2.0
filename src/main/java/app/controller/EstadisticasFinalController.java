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

public class EstadisticasFinalController extends ControllerBase implements Initializable {
    @FXML private Button continuarButton;

    @FXML private GridPane estadisticasGridPane;

    @FXML private Label mensajeLabel;

    @FXML private Label bombasObtenidasLabel;

    @FXML private Label cristalesObtenidosLabel;

    @FXML private Label energiaObtenidaLabel;

    @FXML private Label trampasActivadasLabel;

    @FXML private Label vidaExtraObtenidaLabel;

    @FXML private Label vidaRestanteLabel;

    @FXML
    void onBackButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuJuego.fxml", 500, 370, event);
    }

    @FXML
    void onContinuarButton(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Jugador jugadorParaEstadisticas = GestorLaberinto.getJugador();
        System.out.println(jugadorParaEstadisticas.getVida());
        System.out.println(jugadorParaEstadisticas.getCristales());
        System.out.println(jugadorParaEstadisticas.getBombas());
        System.out.println(jugadorParaEstadisticas.getEnergia());
        /*
        vidaRestanteLabel.setText(String.valueOf(jugadorParaEstadisticas.getVida()));
        cristalesObtenidosLabel.setText(String.valueOf(jugadorParaEstadisticas.getCristales()));
        vidaExtraObtenidaLabel.setText(String.valueOf("0"));
        trampasActivadasLabel.setText("0");
        bombasObtenidasLabel.setText(String.valueOf(jugadorParaEstadisticas.getBombas()));
        energiaObtenidaLabel.setText(String.valueOf(jugadorParaEstadisticas.getEnergia()));*/

        if (GestorLaberinto.isHaPerdido()) {
            mensajeLabel.setText("PERDISTE");
            mensajeLabel.setTextFill(javafx.scene.paint.Color.RED);
        } else {
            mensajeLabel.setText("FELICIDADES");
            mensajeLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        }
    }
}
