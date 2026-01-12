package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de Celda y su función es
 * restarle vida al personaje del usuario en
 * el laberinto.
 *
 * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */

public class Trampa extends Celda {
    private int porcentajeDanio;
    GestorImagenes gestor = new GestorImagenes();

    /**
     * Constructor que inicializa la trampa con una imagen específica,
     * permite el paso del jugador y establece un daño predeterminado del 20%.
     * * @author Jesus Sifontes y Darwin Marcano
     */
    public Trampa() {
        ImageView imagen = gestor.getImagenTrampa();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        this.porcentajeDanio = 20;
        setTipo("Trampa");
    }
}
