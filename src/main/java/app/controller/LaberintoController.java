package app.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import laberinto.Laberinto;
import laberinto.celdas.Celda;
import laberinto.celdas.GestorImagenes;

import java.util.ArrayList;

public class LaberintoController {
    public int filas = 15;
    public int columnas = 20;
    @FXML private GridPane rootGridPane;
    Laberinto laberinto = new Laberinto(filas, columnas, 1);
    GestorImagenes gestorImage = new GestorImagenes();
    public void initialize() {
        laberinto.imprimirLaberinto();
        rootGridPane.getChildren().clear();
        rootGridPane.getColumnConstraints().clear();
        rootGridPane.getRowConstraints().clear();
        rootGridPane.setPrefSize(columnas * 20, filas * 20);

        Celda[][] matrizLaberinto = laberinto.getLaberinto();

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
