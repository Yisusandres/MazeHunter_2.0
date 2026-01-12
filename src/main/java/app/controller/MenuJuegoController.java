package app.controller;

import app.model.GestionUsuario;
import app.model.GestorLaberinto;
import app.model.usuarios.Usuario;
import app.repository.DatosJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import laberinto.celdas.GestorImagenes;

import java.util.ArrayList;

public class MenuJuegoController extends ControllerBase{
    static Usuario usuario = new Usuario();
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
    }

    @FXML
    public void jugarNuevoLaberinto(ActionEvent event) throws Exception {
        cambiarEscena("/app/laberintoNuevo.fxml", 400, 320, event);
    }
    @FXML
    public void cargarLaberintoGuardado(ActionEvent event){

    }
    @FXML
    public void verEstadisticas(ActionEvent event) throws Exception {
        cambiarEscena("/app/verEstadisticas.fxml", 500, 350, event);

    }
    @FXML
    public void seleccionarSkin(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuInicial.fxml", 350, 370, event);
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
