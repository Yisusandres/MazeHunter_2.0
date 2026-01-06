package app;

import app.model.GestionUsuario;
import app.model.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MainApp extends Application {
    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/imagenes/icono/iconoMazeHunter.png")));

    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<Usuario> usuarios = GestionUsuario.cargarUsuarios("src/main/resources/JSON/usuarios.json");
        GestionUsuario.setListaUsuarios(usuarios);
        GestionUsuario.printUsuarios();
        Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menuInicial.fxml")));
        Scene scene = new Scene(root, 350, 370);
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
