package app;

import app.service.BackgroundService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menuInicial.fxml")));
        BackgroundService.setBackgroundFill(root);
        Scene scene = new Scene(root, 640, 520);
        stage.setTitle("Bienvenida");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
