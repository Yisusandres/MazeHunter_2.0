package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de Celda y su función es
 * restarle vida al personaje del usuario en
 * el laberinto.
 *
 * @author Juan Meneses
 * @version 22.0.2
 * @since 01-11-2025
 */

public class Trampa extends Celda {
    private int porcentajeDanio;
    GestorImagenes gestor = new GestorImagenes();

    public Trampa() {
        ImageView imagen = gestor.getImagenTrampa();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        this.porcentajeDanio = 20;
        setTipo("Trampa");
    }

    public int getPorcentajeDanio() {
        return porcentajeDanio;
    }

    public void setPorcentajeDanio(int porcentajeDanio) {
        this.porcentajeDanio = porcentajeDanio;
    }
}
