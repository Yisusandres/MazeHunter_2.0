package app.controller;

import app.TestLaberinto;
import app.model.GestionUsuario;
import app.model.GestorLaberinto;
import app.model.Jugador;
import app.model.usuarios.Usuario;
import app.repository.DatosJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import laberinto.Laberinto;
import laberinto.Posicion.Pair;

import java.io.IOException;

public class LaberintoNuevoController extends ControllerBase{
    @FXML private ImageView imagenPersonaje;
    @FXML private Label tamanoLabel;
    @FXML private Label trampasLabel;
    @FXML private Label energiaLabel;
    @FXML private Label bombaLabel;
    @FXML private Label dificultadLabel;
    @FXML private MenuButton dificultadMenuButton;
    @FXML private MenuItem facilMenuItem;
    @FXML private MenuItem normalMenuItem;
    @FXML private MenuItem dificilMenuItem;
    @FXML private Label errorDificultad;

    Stage stage;
    public static Usuario usuario = new Usuario();
    private DatosJson datosJson = new DatosJson();

    public DatosJson getDatosJson() {
        return datosJson;
    }

    public void setDatosJson(DatosJson datosJson) {
        this.datosJson = datosJson;
    }

    public void initialize() {
        usuario = MenuJuegoController.getUsuario();
        dificultadSeleccionada = 0;
    }

    public static void setDificultadSeleccionada(int dificultadSeleccionada) {
        LaberintoNuevoController.dificultadSeleccionada = dificultadSeleccionada;
    }

    public void onFacil(ActionEvent event) {
        setLabelDificultad("5x10 a 15x25", "2 o 3", "2 o 3", "5");
        dificultadLabel.setText("Fácil");
        setDificultadSeleccionada(1);
    }

    public void onNormal(ActionEvent event) {
        setLabelDificultad("16x26 a 25x35", "4 o 5", "4 o 5", "15");
        dificultadLabel.setText("Normal");
        setDificultadSeleccionada(2);
    }

    public void onDificil(ActionEvent event) {
        setLabelDificultad("26x36 a 45x65", "6, 12 y 18", "6, 12 y 18", "20");
        dificultadLabel.setText("Dificil");
        setDificultadSeleccionada(3);
    }

    public void onAvanzado(ActionEvent event) {
        setLabelDificultad("46x66 a 55x75", "40", "25", "25");
        dificultadLabel.setText("Avanzado");
        setDificultadSeleccionada(4);
    }

    public void onContinuar(ActionEvent event) throws IOException {
        if (dificultadSeleccionada == 0){
            errorDificultad.setVisible(true);
        } else {
            errorDificultad.setVisible(false);
            String nombre = usuario.getNombreUsuario();
            String correo = usuario.getCorreo();
            String contrasena = usuario.getContrasena();
            LaberintoController.setJugador(new Jugador(nombre, correo, contrasena));
            Pair<Integer, Integer> tamano = devolverTamano(dificultadSeleccionada);
            LaberintoController.setColumnas(tamano.second);
            LaberintoController.setFilas(tamano.first);
            System.out.println("Tamano laberinto: " + tamano.first + "x" + tamano.second);
            LaberintoController.setDificultad(dificultadSeleccionada);
            Laberinto laberinto = new Laberinto(tamano.first, tamano.second, dificultadSeleccionada);
            LaberintoController.setLaberinto(laberinto);
            LaberintoController.setMatrizLaberinto(laberinto.getLaberinto());

            Jugador jugador = new Jugador(usuario.getNombreUsuario(), usuario.getCorreo(), usuario.getContrasena());
            LaberintoController.setJugador(jugador);
            LaberintoController.setGestor(new GestorLaberinto(laberinto, jugador));

            usuario.setLaberintosJugados(usuario.getLaberintosJugados()+1);
            System.out.println(usuario.getLaberintosJugados() + "- " + usuario.getCorreo());
            GestionUsuario.actualizarUsuario(usuario);
            datosJson.actualizarDatos(GestionUsuario.getListaUsuarios());

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

    }

    public void onBackButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuInicial.fxml", 380, 340, event);
    }

    public void setLabelDificultad(String tamano, String trampas, String energia, String bomba) {
        tamanoLabel.setText(tamano);
        tamanoLabel.setVisible(true);
        trampasLabel.setText(trampas);
        trampasLabel.setVisible(true);
        energiaLabel.setText(energia);
        energiaLabel.setVisible(true);
        bombaLabel.setText(bomba);
        bombaLabel.setVisible(true);
    }

    private static int dificultadSeleccionada = 0; // 0: Ninguna, 1: Fácil, 2: Normal, 3: Difícil

    public static int getDificultadSeleccionada() {
        return dificultadSeleccionada;
    }

    public Pair<Integer, Integer> devolverTamano(int dificultad){
        int filas, columnas;
        Pair<Integer, Integer> tamano = new Pair<>();
        if (dificultad == 1){
            filas = GestorLaberinto.aleatorio(6, 15);
            if (filas < 15){
                columnas = filas + 5;
            } else{
                columnas = filas + 10;
            }
            tamano.first = filas;
            tamano.second = columnas;
        } else if (dificultad == 2) {
            filas = GestorLaberinto.aleatorio(16, 25);
            columnas = filas + 10;
            tamano.first = filas;
            tamano.second = columnas;
        } else if (dificultad == 3) {
            filas = GestorLaberinto.aleatorio(26, 45);
            if (filas <= 36){
                columnas = filas + 10;
            } else{
                columnas = filas + 20;
            }
            tamano.first = filas;
            tamano.second = columnas;
        } else if(dificultad == 4) {
            filas = GestorLaberinto.aleatorio(46, 75);
            columnas = filas + 20;
            tamano.first = filas;
            tamano.second = columnas;
        }
        return tamano;
    }
}
