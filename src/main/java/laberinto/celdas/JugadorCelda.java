package laberinto.celdas;
import javafx.scene.image.ImageView;

/**
 * Clase que hereda de Celda y representa al
 * personaje del usuario dentro del laberinto.
 *
 * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 01-11-2025
 */
public class JugadorCelda extends Celda {
    private int salud;
    GestorImagenes gestor = new GestorImagenes();
    /**
     * Constructor que asigna la imagen del jugador y establece su salud inicial en 100.
     * @author Jesus Sifontes
     */
    public JugadorCelda() {
        ImageView imagen = gestor.getImagenJugador();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        salud = 100;
        setTipo("Jugador");
    }
}
