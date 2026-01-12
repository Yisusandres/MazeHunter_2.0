package laberinto.celdas;

import javafx.scene.image.ImageView;

/**
 * Representa un ítem que restaura el combustible o energía necesaria para acciones especiales.
 * * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public class Energia extends Celda {
    GestorImagenes gestor = new GestorImagenes();
    /**
     * Constructor que inicializa la celda como energía.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public Energia() {
        ImageView imagen = gestor.getImagenEnergia();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        setTipo("Energia");
    }
}
