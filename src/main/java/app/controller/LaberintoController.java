package app.controller;

import app.model.GestionUsuario;
import app.model.GestorLaberinto;
import app.model.usuarios.GuardadoPartida;
import app.model.Jugador;
import app.model.movimiento.*;
import app.model.usuarios.Usuario;
import app.repository.DatosJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.GestureEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import laberinto.Laberinto;
import laberinto.celdas.Celda;
import laberinto.celdas.GestorImagenes;
/**
 * Clase encargada de manejar la interfaz grafica del laberinto 
 * @author Jesus Sifontes
 * @version 22.0.2
 * @since 11-01-2026
 */
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

    static GestorLaberinto gestor;
    private static Laberinto laberinto;
    private static Celda[][] matrizLaberinto;
    GestorImagenes gestorImage = new GestorImagenes();

    public static Jugador jugador;
    private static Usuario usuario = GestorLaberinto.getUsuarioActivo();
    private static DatosJson datosJson = new DatosJson();
    /**
     * Obtiene el jugador actual
     * Proporciona métodos para la autenticación, búsqueda, registro y recuperación de credenciales.
     * @author Jesus Sifontes
     * @return Jugador 
     */
    public static Jugador getJugador() {
        return jugador;
    }

    /**
     * Establece el jugador actual
     * @author Jesus Sifontes
     * @param jugador 
     */
    public static void setJugador(Jugador jugador) {
        LaberintoController.jugador = jugador;
    }

    /**
     * Establece la matriz correspondiente a la partida anterior del jugador actual
     * @author Jesus Sifontes
     * @param matrizLaberinto 
     */
    public static void setMatrizLaberinto(Celda[][] matrizLaberinto) {
        LaberintoController.matrizLaberinto = matrizLaberinto;
    }

    /*
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

    /**
     * Metodo que funciona para manejar toda la logica de juego
     * @author Darwin Marcano y Jesus Sifontes
     * @param event 
     */
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
        GuardadoPartida guardadoPartida = usuario.getGuardadoPartida();
        guardadoPartida.setLaberintoGuardado(GestorLaberinto.guardarLaberinto());

        usuario.setGuardadoPartida(guardadoPartida);
        GestionUsuario.actualizarUsuario(usuario);
        datosJson.actualizarDatos(GestionUsuario.getListaUsuarios());
        if (gestor.verificarVictoria()) {
            usuario.setPartidasGanadas(usuario.getPartidasGanadas()+1);
            System.out.println(usuario.getPartidasGanadas() + "- " + usuario.getCorreo());
            GestionUsuario.actualizarUsuario(usuario);
            datosJson.actualizarDatos(GestionUsuario.getListaUsuarios());
            GestorLaberinto.setHaPerdido(false);
            Jugador jugadorFinal = new Jugador(usuario.getNombreUsuario(), usuario.getCorreo(), usuario.getContrasena(), usuario.getGuardadoPartida());
            EstadisticasFinalController.setJugadorParaEstadisticas(jugadorFinal);
            usuario.setGuardadoPartida(null);
            GestionUsuario.actualizarUsuario(usuario);
            datosJson.actualizarDatos(GestionUsuario.getListaUsuarios());
            try {
                cambiarEscenaDesdeNodo("/app/estadisticasFinal.fxml", 500, 370, rootGridPane);
            } catch (Exception e) {
                System.out.println("Error al cargar la pantalla de victoria: " + e.getMessage());
            }
        }
        if(gestor.verificarDerrota()) {
            usuario.setPartidasPerdidas(usuario.getPartidasPerdidas()+1);
            System.out.println(usuario.getPartidasPerdidas() + "- " + usuario.getCorreo());
            GestionUsuario.actualizarUsuario(usuario);
            datosJson.actualizarDatos(GestionUsuario.getListaUsuarios());
            GestorLaberinto.setHaPerdido(true);
            Jugador jugadorFinal = new Jugador(usuario.getNombreUsuario(), usuario.getCorreo(), usuario.getContrasena(), usuario.getGuardadoPartida());
            EstadisticasFinalController.setJugadorParaEstadisticas(jugadorFinal);
            usuario.setGuardadoPartida(null);
            GestionUsuario.actualizarUsuario(usuario);
            datosJson.actualizarDatos(GestionUsuario.getListaUsuarios());
            try {
                cambiarEscenaDesdeNodo("/app/estadisticasFinal.fxml", 500, 370, rootGridPane);
            } catch (Exception e) {
                System.out.println("Error al cargar la pantalla de victoria: " + e.getMessage());
            }
        }
    }

    /**
     * Metodo para verificar si el usuario desea activar el radar de bombas
     * @author Darwin Marcano
     */
    private void activarModoBomba() {
        modoBombaActivo = true;
        filaObjetivo = gestor.getPosicionJugador().first;
        columnaObjetivo = gestor.getPosicionJugador().second;
        gestor.radearBomba(filaObjetivo, columnaObjetivo);
    }

    /**
     * Metodo para manejar la logica de explosion de bombas
     * @author Darwin Marcano
     */
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

    /**
     * Metodo para manejar el movimiento del jugador con teclas WASD
     * @author Darwin Marcano
     */
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

    /**
     * Establece los valores de tamanio para el GridPane
     * @author Jesus Sifontes 
     */
    public void initialize() {
        usuario = GestorLaberinto.getUsuarioActivo();

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
        guardadoPartida.setLaberintoGuardado(GestorLaberinto.guardarLaberinto());
        usuario.setGuardadoPartida(guardadoPartida);
        GestionUsuario.actualizarUsuario(usuario);

        datosJson.actualizarDatos(GestionUsuario.getListaUsuarios());


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

    /**
     * Metodo para actualizar la vista del laberinto con cada movimiento
     * @author Jesus Sifontes
     */
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


    /**
     * Obtiene el numero de filas
     * @author Jesus Sifontes
     * @return int numero de filas 
     */
    public static int getFilas() {
        return filas;
    }

    /**
     * Establece el numero de filas
     * @author Jesus Sifontes
     * @param filas
     */
    public static void setFilas(int filas) {
        LaberintoController.filas = filas;
    }

    /**
     * Obtiene el numero de columnas
     * @author Jesus Sifontes
     * @return int numero de columnas 
     */
    public static int getColumnas() {
        return columnas;
    }

    /**
     * Establece el numero de columnas
     * @author Jesus Sifontes
     * @param columnas
     */
    public static void setColumnas(int columnas) {
        LaberintoController.columnas = columnas;
    }

    /**
     * Obtiene la dificultad seleccionada
     * @author Jesus Sifontes
     * @return int numero de dificultad 
     */
    public static int getDificultad() {
        return dificultad;
    }

    /**
     * Establece la dificultad del laberinto correspondiente
     * @author Jesus Sifontes
     * @param dificultad
     */
    public static void setDificultad(int dificultad) {
        LaberintoController.dificultad = dificultad;
    }

    /**
     * Obtiene el laberinto del jugador
     * @author Jesus Sifontes
     * @return Laberinto 
     */
    public static Laberinto getLaberinto() {
        return laberinto;
    }

    /**
     * Establece el laberinto
     * @author Jesus Sifontes
     * @param laberinto
     */
    public static void setLaberinto(Laberinto laberinto) {
        LaberintoController.laberinto = laberinto;
    }
    /**
     * Metodo que devuelve al usuario a la ventana anterior
     * @author Jesus Sifontes
     */
    @FXML
    public void onBackButton(ActionEvent event) throws Exception {
        GuardadoPartida guardadoPartida = new GuardadoPartida();
        guardadoPartida.setLaberintoGuardado(GestorLaberinto.guardarLaberinto());
        usuario.setGuardadoPartida(guardadoPartida);
        GestionUsuario.actualizarUsuario(usuario);
        cambiarEscena("/app/menuJuego.fxml", 380, 340, event);
    }

    /**
     * Establece el gestor para obtener datos guardados
     * @author Jesus Sifontes
     */
    public static void setGestor(GestorLaberinto gestor) {
        LaberintoController.gestor = gestor;
    }
}
