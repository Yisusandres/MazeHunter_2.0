package app.controller;

import app.model.GestionUsuario;
import app.model.*;
import laberinto.*;
import app.model.usuarios.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class RecuperarContrasenaController extends ControllerBase {
    @FXML public TextField campoCorreo;
    @FXML public Label errorCorreo;
    @FXML public Label contrasena;
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    @FXML
    public void onBuscar(){
        String correo = campoCorreo.getText().strip();
        errorCorreo.setTextFill(javafx.scene.paint.Color.web("#8d2a00"));
        listaUsuarios = GestionUsuario.getListaUsuarios();
        String recuperarContrasena = GestionUsuario.recuperarContrasena(correo, listaUsuarios);
        if (recuperarContrasena.equals("Usuario no existe")){
            System.out.println("Correo incorrecto: " + correo);
            errorCorreo.setText("El usuario no fue encontrado");
            errorCorreo.setVisible(true);
            contrasena.setText("Contrasena:");
        } else{
            System.out.println("Contraseña recuperada: " + recuperarContrasena);
            contrasena.setText("Contrasena:" + recuperarContrasena);
            errorCorreo.setVisible(false);
            errorCorreo.setText("");
        }
    }

    @FXML
    public void onBackButton(ActionEvent event) throws Exception {
        cambiarEscena("/app/iniciarSesion.fxml", 520, 370, event);
    }

}
