package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de Celda y es la posicion del
 * laberinto a la que tiene que llegar el usuario
 * para ganar.
 *
 * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public class Salida extends Celda {
    GestorImagenes gestor = new GestorImagenes();
    /**
     * Constructor que configura la celda como la meta del laberinto.
     * Define la imagen de salida, la marca como no traspasable inicialmente
     * y le asigna su tipo identificador.
     * * @author Jesus Sifontes y Darwin Marcano
     */
    public Salida(){
        ImageView imagen = gestor.getImagenSalida();
        setImagenCelda(imagen);
        setTraspasable(false);
        setVisible(true);
        setTipo("Salida");
    }
}
