package app.controller;

import app.model.GestorLaberinto;
import app.model.GuardadoPartida;
import app.model.Jugador;
import app.model.movimiento.*;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import laberinto.Laberinto;
import laberinto.celdas.Celda;
import laberinto.celdas.GestorImagenes;


import java.util.ArrayList;

import static javafx.scene.input.KeyCode.F;

public class LaberintoController {
    public int filas = 55;
    public int columnas = 65;
    @FXML private GridPane rootGridPane;
    GestorLaberinto gestor;
    Laberinto laberinto = new Laberinto(filas, columnas, 1);
    GestorImagenes gestorImage = new GestorImagenes();

    public void manejarTeclado(KeyEvent event) {
        Command comando = null;
        int filaActual = gestor.getPosicionJugador().first;
        int columnaActual = gestor.getPosicionJugador().second;

        int filaNueva = filaActual;
        int columnaNueva = columnaActual;
        switch (event.getCode()) {
            case W:
                comando = new Arriba(gestor);
                filaNueva--;
                break;
            case A:
                comando = new Izquierda(gestor);
                columnaNueva--;
                break;
            case S:
                comando = new Abajo(gestor);
               filaNueva++;
                break;
            case D:
                comando = new Derecha(gestor);
                columnaNueva++;
                break;
        }

        if(comando != null) {
            comando.ejecutar(filaNueva, columnaNueva);
            actualizarLaberinto();
        }
    }


    public void initialize() {
        rootGridPane.getChildren().clear();
        rootGridPane.getColumnConstraints().clear();
        rootGridPane.getRowConstraints().clear();
        rootGridPane.setPrefSize(columnas * 20, filas * 20);

        Celda[][] matrizLaberinto = laberinto.getLaberinto();
        GuardadoPartida guardadoPartida = new GuardadoPartida();
        Jugador jugadorTemporal = new Jugador("User", "mail@mail.com", "123", false, 100, guardadoPartida);
        this.gestor = new GestorLaberinto(laberinto, jugadorTemporal);

        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                ImageView image = matrizLaberinto[i][j].getImagenCelda();
                image.setFitWidth(20);
                image.setFitHeight(20);
                Pane contenedorImagen = new Pane();
                contenedorImagen.setPrefSize(20,20);
                contenedorImagen.getChildren().add(image);
                rootGridPane.add(contenedorImagen, j, i);
            }
        }
    }

    public void actualizarLaberinto() {
        Celda[][] matrizLaberinto = laberinto.getLaberinto();
        rootGridPane.getChildren().clear();
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                ImageView image = matrizLaberinto[i][j].getImagenCelda();
                image.setFitWidth(20);
                image.setFitHeight(20);
                Pane contenedorImagen = new Pane();
                contenedorImagen.setPrefSize(20,20);
                contenedorImagen.getChildren().add(image);
                rootGridPane.add(contenedorImagen, j, i);
            }
        }
    }
}
