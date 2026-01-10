package app.controller;

import app.model.GestorLaberinto;
import app.model.usuarios.GuardadoPartida;
import app.model.Jugador;
import app.model.movimiento.*;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import laberinto.Laberinto;
import laberinto.celdas.Celda;
import laberinto.celdas.GestorImagenes;

public class LaberintoController {

    public int filas = 30;
    public int columnas = 40;
    private boolean modoBombaActivo = false;
    private int filaObjetivo, columnaObjetivo;

    @FXML private GridPane rootGridPane;
    GestorLaberinto gestor;
    Laberinto laberinto = new Laberinto(filas, columnas, 3);
    GestorImagenes gestorImage = new GestorImagenes();

    /*public void manejarTeclado(KeyEvent event) {
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
            case F:
                gestor.radearBomba(filaActual, columnaActual);
                actualizarLaberinto();
                break;
        }

        if(comando != null) {
            comando.ejecutar(filaNueva, columnaNueva);
            actualizarLaberinto();
        }
    }*/


    public void manejarTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.F) {
            if (!modoBombaActivo) {
                activarModoBomba();
            } else {
                modoBombaActivo = false;
                gestor.quitarCaminosConPuntos();
            }
            actualizarLaberinto();
            return;
        }
        if (modoBombaActivo) {
            manejarSeleccionBomba(event);
            modoBombaActivo = false;
        } else {
            manejarMovimientoNormal(event);
        }
        actualizarLaberinto();
    }

    private void activarModoBomba() {
        modoBombaActivo = true;
        filaObjetivo = gestor.getPosicionJugador().first;
        columnaObjetivo = gestor.getPosicionJugador().second;
        gestor.radearBomba(filaObjetivo, columnaObjetivo);
    }

    private void manejarSeleccionBomba(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                filaObjetivo--;
                break;
            case S:
                filaObjetivo++;
                break;
            case A:
                columnaObjetivo--;
                break;
            case D:
                columnaObjetivo++;
                break;
        }
        gestor.ponerBomba(filaObjetivo, columnaObjetivo);
        actualizarLaberinto();
        actualizarLaberinto();
        gestor.quitarCaminosConPuntos();
        actualizarLaberinto();
    }

    private void manejarMovimientoNormal(KeyEvent event) {
        Command comando = null;
        int fila = gestor.getPosicionJugador().first;
        int columna = gestor.getPosicionJugador().second;

        switch (event.getCode()) {
            case W -> { comando = new Arriba(gestor); fila--; }
            case A -> { comando = new Izquierda(gestor); columna--; }
            case S -> { comando = new Abajo(gestor); fila++; }
            case D -> { comando = new Derecha(gestor); columna++; }
        }

        if (comando != null) {
            comando.ejecutar(fila, columna);
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
