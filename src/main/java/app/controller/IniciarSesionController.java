package app.controller;

import app.model.GestionUsuario;
import app.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class IniciarSesionController extends ControllerBase{
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();


    @FXML private TextField campoCorreo;
    @FXML private PasswordField campoContrasena;
    @FXML private Button loginButton;
    @FXML private Button backButton;
    @FXML private Button verContra_Button;
    @FXML private Label errorContrasena;
    @FXML private Label errorCorreo;
    @FXML private Label errorAutenticacion;

    @FXML
    public void onBackButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/menuInicial.fxml", 350, 370, event);
    }

    @FXML
    public void onLoginButton(ActionEvent event) {
        String correo = campoCorreo.getText().strip();
        String contrasena = campoContrasena.getText().strip();

        errorContrasena.setTextFill(javafx.scene.paint.Color.web("#8d2a00"));
        errorCorreo.setTextFill(javafx.scene.paint.Color.web("#8d2a00"));

        listaUsuarios = GestionUsuario.getListaUsuarios();

        String autenticado = GestionUsuario.autenticarCorreo(correo, contrasena, listaUsuarios);

        if (correo.isEmpty()){
            System.out.println("correo vacío");
            errorCorreo.setText("El correo no puede estar vacío.");
            errorCorreo.setVisible(true);
        } else if (autenticado.equals("Usuario no existe")){
            System.out.println("Correo incorrecto: " + correo);
            errorCorreo.setText("El usuario no fue encontrado");
            errorCorreo.setVisible(true);
        } else{
            System.out.println(correo);
            errorCorreo.setVisible(false);
            errorCorreo.setText("");
        }

        if (contrasena.isEmpty()){
            System.out.println("contrasena vacía");
            errorContrasena.setText("La contraseña no puede estar vacía.");
            errorContrasena.setVisible(true);
        } else if (autenticado.equals("Contraseña incorrecta")){
            System.out.println(contrasena);
            errorContrasena.setText("La contraseña es incorrecta");
            errorContrasena.setVisible(true);
        } else{
            System.out.println(contrasena);
            errorContrasena.setVisible(false);
            errorContrasena.setText("");
        }

        if (autenticado.equals("Autenticación exitosa")){
            System.out.println("Inicio de sesión exitoso");
            MenuJuegoController.setUsuario(GestionUsuario.buscarUsuarioPorCorreo(correo, listaUsuarios));
            try {
                cambiarEscena("/app/menuJuego.fxml", 500, 370, event);
            } catch (Exception e) {
                System.out.println("Error al cargar la ventana del juego: " + e.getMessage());
            }
        }
    }


    @FXML
    public void verContrasena(ActionEvent actionEvent) {
        String contrasena = "";
        if (verContra_Button.getText().equals("(Mostrar)")) {
            verContra_Button.setText("(Ocultar)");
            contrasena = campoContrasena.getText();
            campoContrasena.setPromptText(contrasena);
            campoContrasena.setText("");
        } else {
            verContra_Button.setText("(Mostrar)");
            contrasena = campoContrasena.getPromptText();
            campoContrasena.setText(contrasena);
            campoContrasena.setPromptText("");
        }
    }
}
