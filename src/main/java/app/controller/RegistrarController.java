package app.controller;

import app.service.Encriptacion;
import app.service.ValidarRegex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegistrarController {
    private Scene scene;
    private Stage stage;

    @FXML public TextField campoCorreo;
    @FXML public TextField campoContrasena;
    @FXML public TextField campoNombreUsuario;
    @FXML public Button crearCuenta_Button;
    @FXML public Button backButton;
    @FXML private Label errorContrasena;
    @FXML private Label errorCorreo;
    @FXML private Label errorNombreUsuario;

    @FXML
    public void onBackButton(ActionEvent event) throws IOException {
        VBox root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/app/menuInicial.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 350, 370);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onCrearButton(ActionEvent event) throws IOException {
        String correo = campoCorreo.getText().strip();
        String contrasena = campoContrasena.getText().strip();
        String nombreUsuario = campoNombreUsuario.getText().strip();

        errorContrasena.setTextFill(javafx.scene.paint.Color.web("#8d2a00"));
        errorCorreo.setTextFill(javafx.scene.paint.Color.web("#8d2a00"));
        errorNombreUsuario.setTextFill(javafx.scene.paint.Color.web("#8d2a00"));

        if (correo.isEmpty()){
            System.out.println("correo vacío");
            errorCorreo.setText("El correo no puede estar vacío.");
            errorCorreo.setVisible(true);
        } else if (!ValidarRegex.validarCorreo(correo)){
            System.out.println("formato de correo incorrecto: " + correo);
            errorCorreo.setText("formato de correo incorrecto.");
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
        } else if (! ValidarRegex.validarContrasena(contrasena)){
            System.out.println(contrasena);
            errorContrasena.setText("La contraseña es incorrecta");
            errorContrasena.setVisible(true);
        } else{
            System.out.println(contrasena);
            errorContrasena.setVisible(false);
            errorContrasena.setText("");
        }

        if (nombreUsuario.isEmpty()) {
            System.out.println("nombre de usuario vacío");
            errorNombreUsuario.setText("El nombre no puede estar vacío.");
            errorNombreUsuario.setVisible(true);
        } else{
            System.out.println(nombreUsuario);
            errorNombreUsuario.setVisible(false);
            errorNombreUsuario.setText("");
        }
    }
}
