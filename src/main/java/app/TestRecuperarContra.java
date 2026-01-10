package app;

import app.model.GestionUsuario;
import app.model.usuarios.Usuario;
import app.repository.AlmacenDatos;
import app.repository.DatosJson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class TestRecuperarContra extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/app/recuperarContrasena.fxml")));
        Scene scene = new Scene(root, 260, 205);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
