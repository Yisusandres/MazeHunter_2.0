package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de celda y representa la
 * puntuación del usuario en el laberinto.
 * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */

public class Cristal extends Celda {
    private int valor;
    GestorImagenes gestor = new GestorImagenes();
    /**
     * Constructor que inicializa la celda como cristal.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public Cristal(int valor){
        this.valor = valor;
        ImageView imagen = gestor.getImagenCristal();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        setTipo("Cristal");
    }
}
