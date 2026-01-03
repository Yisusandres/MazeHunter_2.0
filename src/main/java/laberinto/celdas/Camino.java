package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de Celda y pertenece a
 * laberinto.
 * @author Juan Meneses
 * @version 22.0.2
 * @since 01-11-2025
 */
public class Camino extends Celda {
    GestorImagenes gestor = new GestorImagenes();
    public Camino() {
        ImageView imagen = gestor.getImagenCamino();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        setTipo("Camino");
    }
}

