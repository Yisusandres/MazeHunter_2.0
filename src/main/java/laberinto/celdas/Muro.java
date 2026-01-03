package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de Celda y representa los espacios
 * por donde el usuario no puede transitar.
 *
 * @author Juan Meneses
 * @version 22.0.2
 * @since 01-11-2025
 */
public class Muro extends Celda {
    GestorImagenes gestor = new GestorImagenes();

    public Muro() {
        ImageView imagen = gestor.getImagenMuro();
        setImagenCelda(imagen);
        setTraspasable(false);
        setVisible(true);
        setTipo("Muro");
    }
}
