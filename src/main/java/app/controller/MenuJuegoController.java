package app.controller;

import app.model.GestionUsuario;
import app.model.GestorLaberinto;
import app.model.Jugador;
import app.model.usuarios.GuardadoPartida;
import app.model.usuarios.Usuario;
import app.repository.DatosJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import laberinto.Laberinto;
import laberinto.Posicion.Pair;
import laberinto.celdas.*;

import java.io.IOException;
import java.util.ArrayList;

public class MenuJuegoController extends ControllerBase{
    static Usuario usuario = new Usuario();
    @FXML public Label errorLaberinto;
    public Button buttonRegistrar;
    public Button buttonIniciarSesion1;
    public Button backButton;
    public Button BackButton;
    public Button nuevoLaberinto;
    @FXML
    private Label nombreUsuarioLabel;
    private DatosJson datosJson = new DatosJson();

    public DatosJson getDatosJson() {
        return datosJson;
    }

    public void setDatosJson(DatosJson datosJson) {
        this.datosJson = datosJson;
    }

    public MenuJuegoController() {
    }

    public void initialize() {
        if (usuario != null) {
            nombreUsuarioLabel.setText(usuario.getNombreUsuario());
        }
        GestorImagenes.setRutaPersonaje("/imagenes/personajes/personajeThomas.png");
        ArrayList<Usuario> listaUsuarios = datosJson.cargarDatos();
        GestionUsuario.setListaUsuarios(listaUsuarios);
        usuario = GestionUsuario.buscarUsuarioPorCorreo(usuario.getCorreo(), listaUsuarios);
        errorLaberinto.setVisible(false);
    }

    @FXML
    public void jugarNuevoLaberinto(ActionEvent event) throws Exception {
        cambiarEscena("/app/laberintoNuevo.fxml", 400, 320, event);
    }
    @FXML
    public void cargarLaberintoGuardado(ActionEvent event) throws IOException {
        GuardadoPartida guardadoPartida = usuario.getGuardadoPartida();
        if (guardadoPartida == null){
            System.out.println("No hay partida guardada");
            errorLaberinto.setVisible(true);
            return;
        }
        int[][] arrayInts = guardadoPartida.getLaberintoGuardado();
        Pair<Integer, Integer> posicionJugador = new Pair<>();
        Pair<Integer, Integer> posicionSalida = new Pair<>();

        Celda[][] arrayCelda = new Celda[arrayInts.length][arrayInts[0].length];
        boolean llaveEncontrada = false, llaveRojaEncontrada = false;
        for (int i = 0; i < arrayInts.length; i++){
            for (int j = 0; j < arrayInts[0].length; j++){
                if (arrayInts[i][j] == 1){
                    arrayCelda[i][j] = new Muro();
                } else if(arrayInts[i][j] == 2){
                    arrayCelda[i][j] = new MuroRojo();
                } else if(arrayInts[i][j] == 3){
                    arrayCelda[i][j] = new Camino();
                } else if(arrayInts[i][j] == 4){
                    arrayCelda[i][j] = new Trampa();
                } else if(arrayInts[i][j] == 5){
                    arrayCelda[i][j] = new Cristal(3);
                } else if(arrayInts[i][j] == 6){
                    arrayCelda[i][j] = new Bomba();
                } else if(arrayInts[i][j] == 7){
                    arrayCelda[i][j] = new Energia();
                } else if(arrayInts[i][j] == 8){
                    arrayCelda[i][j] = new VidaExtra(10);
                } else if(arrayInts[i][j] == 9){
                    arrayCelda[i][j] = new JugadorCelda();
                    posicionJugador.first = i;
                    posicionJugador.second = j;
                } else if(arrayInts[i][j] == 10){
                    arrayCelda[i][j] = new LLave();
                    llaveEncontrada = true;
                } else if(arrayInts[i][j] == 11){
                    arrayCelda[i][j] = new Salida();
                    posicionSalida.first = i;
                    posicionSalida.second = j;
                } else if(arrayInts[i][j] == 12){
                    arrayCelda[i][j] = new LLaveDeExplosion();
                    llaveRojaEncontrada = true;
                }
            }
        }
        LaberintoController.setMatrizLaberinto(arrayCelda);
        Laberinto laberintoGuardado = new Laberinto(arrayInts.length, arrayInts[0].length, arrayCelda);

        Jugador jugador = new Jugador(usuario.getNombreUsuario(), usuario.getCorreo(), usuario.getContrasena(), usuario.getGuardadoPartida());
        if (!llaveEncontrada){
            jugador.setLlave(true);
        }
        if (!llaveRojaEncontrada){
            jugador.setLlaveDeExplosion(true);
        }

        LaberintoController.setLaberinto(laberintoGuardado);
        LaberintoController.setJugador(jugador);
        GestorLaberinto gestor = new GestorLaberinto(laberintoGuardado, jugador, posicionJugador, posicionSalida);
        GestorLaberinto.desbloquearPuerta(llaveEncontrada);
        LaberintoController.setGestor(gestor);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/laberinto.fxml"));
        Pane root = loader.load();
        Stage stage = (javafx.stage.Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        LaberintoController controller = loader.getController();
        Scene scene = new Scene(root, 800, 620);
        scene.setFill(javafx.scene.paint.Color.web("#3D3452"));
        scene.setOnKeyPressed(controller::manejarTeclado);
        stage.setTitle("Laberinto");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void verEstadisticas(ActionEvent event) throws Exception {
        cambiarEscena("/app/verEstadisticas.fxml", 520, 350, event);

    }

    @FXML
    public void onBackButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuInicial.fxml", 350, 370, event);
    }
    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        MenuJuegoController.usuario = usuario;
    }
}
