package app;

import app.model.GestionUsuario;
import app.model.usuarios.Usuario;
import app.repository.AlmacenDatos;
import app.repository.DatosJson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.jfr.DataAmount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MainApp extends Application {
    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/imagenes/icono/iconoMazeHunter.png")));

    @Override
    public void start(Stage stage) throws IOException {
        AlmacenDatos datos = new DatosJson();
        ArrayList<Usuario> usuarios = datos.cargarDatos();
        GestionUsuario.setListaUsuarios(usuarios);
        GestionUsuario.printUsuarios();

        /*
        ArrayList<Usuario> usuarios = ObtenerJson.cargarDatos();
        GestionUsuario.setListaUsuarios(usuarios);
        GestionUsuario.printUsuarios();
        */

        Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menuInicial.fxml")));
        Scene scene = new Scene(root, 360, 360);
        stage.setTitle("Bienvenida");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(image);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
