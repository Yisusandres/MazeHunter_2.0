package app.controller;
import javafx.event.ActionEvent;

/**
 * Interfaz para el cambio de escena entre controladores
 * @author Jesus Sifontes
 * @version 22.0.2
 * @since 11-01-2026
 */
public interface ICambioDeScene {
    /**
     * Metodo que recibe la ruta de un archivo fxml y cambia la ventana hacia el archivo correspondiente
     * @author Jesus Sifontes
     */
    void cambiarEscena(String fxmlFilePath, double width, double height, ActionEvent event) throws Exception;
}
