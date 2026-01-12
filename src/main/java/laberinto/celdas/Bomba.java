package laberinto.celdas;

import javafx.scene.image.ImageView;

/**
 * Representa un elemento de munición que permite al jugador destruir muros rojos unicamente.
 * * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public class Bomba extends Celda {
    GestorImagenes gestor = new GestorImagenes();
    /**
     * Constructor que configura la celda como una bomba recolectable.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public Bomba() {
        ImageView imagen = gestor.getImagenBomba();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        setTipo("Bomba");
    }
}
