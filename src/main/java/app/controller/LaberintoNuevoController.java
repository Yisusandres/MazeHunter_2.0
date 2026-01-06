package app.controller;

import app.TestLaberinto;
import app.model.GestionUsuario;
import app.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jdk.incubator.vector.VectorOperators;
import laberinto.celdas.GestorImagenes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class LaberintoNuevoController extends ControllerBase{
    @FXML private ImageView imagenPersonaje;
    @FXML private Label tamanoLabel;
    @FXML private Label trampasLabel;
    @FXML private Label energiaLabel;
    @FXML private Label bombaLabel;
    @FXML private MenuButton dificultadMenuButton;
    @FXML private MenuItem facilMenuItem;
    @FXML private MenuItem normalMenuItem;
    @FXML private MenuItem dificilMenuItem;;

    public void initialize() {

    }

    public static void setDificultadSeleccionada(int dificultadSeleccionada) {
        LaberintoNuevoController.dificultadSeleccionada = dificultadSeleccionada;
    }

    public void onFacil(ActionEvent event) {
        setLabelDificultad("5x10 a 15x25", "2 o 3", "2 o 3", "5");
        facilMenuItem.setVisible(false);
        normalMenuItem.setVisible(true);
        dificilMenuItem.setVisible(true);
        dificultadMenuButton.setText("Facil");
        setDificultadSeleccionada(1);
    }

    public void onNormal(ActionEvent event) {
        setLabelDificultad("5x10 a 15x25", "2 o 3", "2 o 3", "5");
        facilMenuItem.setVisible(true);
        normalMenuItem.setVisible(false);
        dificilMenuItem.setVisible(true);
        dificultadMenuButton.setText("Normal");
        setDificultadSeleccionada(2);
    }

    public void onDificil(ActionEvent event) {
    }

    public void onContinuar(ActionEvent event) throws IOException {
        TestLaberinto testLaberinto  = new TestLaberinto();
        testLaberinto.start(new Stage());
    }

    public void onBackButton(ActionEvent event) {
    }

    public void setLabelDificultad(String tamano, String trampas, String energia, String bomba) {
        tamanoLabel.setText(tamano);
        trampasLabel.setText(trampas);
        energiaLabel.setText(energia);
        bombaLabel.setText(bomba);
    }

    private static int dificultadSeleccionada = 0; // 0: Ninguna, 1: Fácil, 2: Normal, 3: Difícil

    public static int getDificultadSeleccionada() {
        return dificultadSeleccionada;
    }
}
