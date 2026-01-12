package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de Celda y es la clave
 * para salir del laberinto y ganar.
 * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public class LLave extends Celda {
    boolean encontrada;
    GestorImagenes gestor = new GestorImagenes();
    /**
     * Constructor que inicializa la llave como no encontrada.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public LLave(){
        ImageView imagen = gestor.getImagenLlave();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        encontrada = false;
        setTipo("Llave");
    }
}
