package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de Celda y es la posicion del
 * laberinto a la que tiene que llegar el usuario
 * para ganar.
 *
 * @author Juan Meneses
 * @version 22.0.2
 * @since 01-11-2025
 */
public class Salida extends Celda {
    GestorImagenes gestor = new GestorImagenes();
    public Salida(){
        ImageView imagen = gestor.getImagenSalida();
        setImagenCelda(imagen);
        setTraspasable(false);
        setVisible(true);
        setTipo("Salida");
    }
}
