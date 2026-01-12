package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de Celda y pertenece a
 * laberinto.
 * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
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

