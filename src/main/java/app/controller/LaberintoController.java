package app.controller;

import app.model.GestorLaberinto;
import app.model.usuarios.GuardadoPartida;
import app.model.Jugador;
import app.model.movimiento.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import laberinto.Laberinto;
import laberinto.celdas.Celda;
import laberinto.celdas.GestorImagenes;

public class LaberintoController extends ControllerBase {

    public static int filas;
    public static int columnas;
    public Button backButton;
    private boolean modoBombaActivo = false;
    private int filaObjetivo, columnaObjetivo;
    private static int dificultad;
    @FXML private GridPane rootGridPane;
    @FXML private Label bombasLabel;
    @FXML private Label cristalesLabel;
    @FXML private Label energiaLabel;
    @FXML private Label trampasLabel;
    @FXML private Label vidaLabel;
    @FXML private Label userLabel;

    GestorLaberinto gestor;
    Laberinto laberinto;
    GestorImagenes gestorImage = new GestorImagenes();
    public static Jugador jugador;

    public static Jugador getJugador() {
        return jugador;
    }

    public static void setJugador(Jugador jugador) {
        LaberintoController.jugador = jugador;
    }

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
        if (gestor.verificarVictoria()) {
            try {
                cambiarEscenaDesdeNodo("/app/verEstadisticas.fxml", 500, 370, rootGridPane);
            } catch (Exception e) {
                System.out.println("Error al cargar la pantalla de victoria: " + e.getMessage());
            }
        }
    }

    private void activarModoBomba() {
        modoBombaActivo = true;
        filaObjetivo = gestor.getPosicionJugador().first;
        columnaObjetivo = gestor.getPosicionJugador().second;
        gestor.radearBomba(filaObjetivo, columnaObjetivo);
    }

    private void manejarSeleccionBomba(KeyEvent event) {
        if (jugador.getBombas() == 0 ){
            System.out.println("No tienes bombas disponibles");
            gestor.quitarCaminosConPuntos();
            return;
        } else if (jugador.getEnergia() < 20) {
            System.out.println("No tienes suficiente energía para poner una bomba");
            gestor.quitarCaminosConPuntos();
            return;
        }
        else if(!jugador.isLlaveDeExplosion()) {
            System.out.println("No tienes la llave de explosion no puedes explotar muros rojos");
            gestor.quitarCaminosConPuntos();
            return;
        }
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
        jugador.setBombas(jugador.getBombas() - 1);
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
        laberinto = new Laberinto(filas, columnas, dificultad);
        Celda[][] matrizLaberinto = laberinto.getLaberinto();
        rootGridPane.getChildren().clear();
        rootGridPane.getColumnConstraints().clear();
        rootGridPane.getRowConstraints().clear();
        rootGridPane.setPrefSize(columnas * 20, filas * 20);
        vidaLabel.setText("Vida " + jugador.getVida());
        energiaLabel.setText("Energía: " + jugador.getEnergia());
        bombasLabel.setText("Bombas: " + jugador.getBombas());
        cristalesLabel.setText("Cristales: " + jugador.getCristales());
        userLabel.setText("Usuario: " + jugador.getNombreUsuario());


        GuardadoPartida guardadoPartida = new GuardadoPartida();
        this.gestor = new GestorLaberinto(laberinto, jugador);

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
                vidaLabel.setText("Vida " + jugador.getVida());
                energiaLabel.setText("Energía: " + jugador.getEnergia());
                bombasLabel.setText("Bombas: " + jugador.getBombas());
                cristalesLabel.setText("Cristales: " + jugador.getCristales());
                userLabel.setText("Usuario: " + jugador.getNombreUsuario());

                Pane contenedorImagen = new Pane();
                contenedorImagen.setPrefSize(20,20);
                contenedorImagen.getChildren().add(image);
                rootGridPane.add(contenedorImagen, j, i);

            }
        }
    }


    public static int getFilas() {
        return filas;
    }

    public static void setFilas(int filas) {
        LaberintoController.filas = filas;
    }

    public static int getColumnas() {
        return columnas;
    }

    public static void setColumnas(int columnas) {
        LaberintoController.columnas = columnas;
    }

    public static int getDificultad() {
        return dificultad;
    }

    public static void setDificultad(int dificultad) {
        LaberintoController.dificultad = dificultad;
    }

    @FXML
    public void onBackButton(KeyEvent event){

    }
}
