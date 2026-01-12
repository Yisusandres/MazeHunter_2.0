package app.controller;

import app.model.GestionUsuario;
import app.model.usuarios.Usuario;
import app.repository.AlmacenDatos;
import app.repository.DatosJson;
import app.service.Encriptacion;
import app.service.ValidarRegex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class RegistrarController extends ControllerBase{
    private Scene scene;
    private Stage stage;

    @FXML public TextField campoCorreo;
    @FXML public PasswordField campoContrasena;
    @FXML public PasswordField campoContrasena2;
    @FXML public TextField campoNombreUsuario;
    @FXML public Button crearCuenta_Button;
    @FXML public Button backButton;
    @FXML private Label errorContrasena;
    @FXML private Label errorCorreo;
    @FXML private Label errorNombreUsuario;
    /**
     * Cambiar escena al menu Inicial
     * * @author Darwin Marcano
     * @version 22.0.2
     * @since 11-01-2026
     * @param event evento al presionar.
     */
    @FXML
    public void onBackButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuInicial.fxml", 350, 370, event);
    }
    /**
     * Cambiar escena al menu de juego y crear usuario
     * * @author Darwin Marcano
     * @version 22.0.2
     * @since 11-01-2026
     * @param event evento al presionar.
     */
    @FXML
    public void onCrearButton(ActionEvent event) throws Exception {
        String correo = campoCorreo.getText().strip();
        String contrasena = campoContrasena.getText().strip();
        String nombreUsuario = campoNombreUsuario.getText().strip();

        errorContrasena.setTextFill(javafx.scene.paint.Color.web("#8d2a00"));
        errorCorreo.setTextFill(javafx.scene.paint.Color.web("#8d2a00"));
        errorNombreUsuario.setTextFill(javafx.scene.paint.Color.web("#8d2a00"));

        String verificarCorreo = "Incorrecto";
        String verificarContrasena = "Incorrecto";
        String verificarNombreUsuario = "Incorrecto";
        Usuario usuarioVerificar = GestionUsuario.buscarUsuarioPorCorreo(correo, GestionUsuario.getListaUsuarios());

        if (correo.isEmpty()){
            System.out.println("correo vacío");
            errorCorreo.setText("El correo no puede estar vacío.");
            errorCorreo.setVisible(true);
            verificarCorreo = "Incorrecto";
        } else if (!ValidarRegex.validarCorreo(correo)){
            System.out.println("formato de correo incorrecto: " + correo);
            errorCorreo.setText("formato de correo incorrecto.");
            errorCorreo.setVisible(true);
            verificarCorreo = "Incorrecto";
        } else if (usuarioVerificar != null) {
            System.out.println("Correo registrado: " + correo);
            errorCorreo.setText("Correo registrado");
            errorCorreo.setVisible(true);
            verificarCorreo = "Incorrecto";
        } else{
            System.out.println(correo);
            errorCorreo.setVisible(false);
            errorCorreo.setText("");
            verificarCorreo = "Correcto";
        }

        if (contrasena.isEmpty()){
            System.out.println("contrasena vacía");
            errorContrasena.setText("La contraseña no puede estar vacía.");
            errorContrasena.setVisible(true);
            verificarContrasena = "Incorrecto";
        } else if (! ValidarRegex.validarContrasena(contrasena)){
            System.out.println(contrasena);
            errorContrasena.setText("Formato de contrasena inconrrecto");
            errorContrasena.setVisible(true);
            verificarContrasena = "Incorrecto";
        } else if (!contrasena.equals(campoContrasena2.getText())) {
            System.out.println("error contrasenas diferentes");
            errorContrasena.setText("Las contrasenas no coinciden");
            errorContrasena.setVisible(true);
            verificarContrasena = "Incorrecto";
        } else{
            System.out.println(contrasena);
            errorContrasena.setVisible(false);
            errorContrasena.setText("");
            verificarContrasena = "Correcto";
        }

        if (nombreUsuario.isEmpty()) {
            System.out.println("nombre de usuario vacío");
            errorNombreUsuario.setText("El nombre no puede estar vacío.");
            errorNombreUsuario.setVisible(true);
            verificarNombreUsuario = "Incorrecto";
        } else{
            System.out.println(nombreUsuario);
            errorNombreUsuario.setVisible(false);
            errorNombreUsuario.setText("");
            verificarNombreUsuario = "Correcto";
        }

        if (verificarNombreUsuario.equals("Correcto") && verificarCorreo.equals("Correcto") && verificarContrasena.equals("Correcto")){
            Usuario usuario = new Usuario(nombreUsuario, correo, contrasena);
            GestionUsuario.agregarUsuario(usuario);

            System.out.println("Usuario registrado exitosamente.");
            AlmacenDatos almacenDatos = new DatosJson();
            almacenDatos.actualizarDatos(GestionUsuario.getListaUsuarios());
            MenuJuegoController.setUsuario(usuario);
            cambiarEscena("/app/menuJuego.fxml", 380, 340, event);
        }
    }
}
