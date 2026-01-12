package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de Celda y representa los espacios
 * por donde el usuario no puede transitar.
 *
 * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public class Muro extends Celda {
    GestorImagenes gestor = new GestorImagenes();

    /**
     * Constructor que establece la propiedad traspasable en false.
     * @author Jesus Sifontes
     */
    public Muro() {
        ImageView imagen = gestor.getImagenMuro();
        setImagenCelda(imagen);
        setTraspasable(false);
        setVisible(true);
        setTipo("Muro");
    }
}
