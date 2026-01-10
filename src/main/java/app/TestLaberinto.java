package app;

import app.controller.LaberintoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class TestLaberinto extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("laberinto.fxml"));
        Pane root = loader.load();

        LaberintoController controller = loader.getController();

        Scene scene = new Scene(root, 800, 620);
        scene.setFill(javafx.scene.paint.Color.web("#3D3452"));

        scene.setOnKeyPressed(controller::manejarTeclado);

        stage.setTitle("Laberinto");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
