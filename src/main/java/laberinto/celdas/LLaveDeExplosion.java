package laberinto.celdas;
import javafx.scene.image.ImageView;

/**
 * Representa la llave especial que habilita el uso de bombas para destruir muros.
 * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public class LLaveDeExplosion extends Celda {
    boolean encontrada;
    GestorImagenes gestor = new GestorImagenes();
    /**
     * Constructor que inicializa la celda como llave de explosion.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public LLaveDeExplosion(){
        ImageView imagen = gestor.getImagenLlaveDeExplosion();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        encontrada = false;
        setTipo("LlaveDeExplosion");
    }
}
