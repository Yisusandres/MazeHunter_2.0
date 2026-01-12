package laberinto.celdas;
import javafx.scene.image.ImageView;

/**
 * Clase que hereda de Celda y representa los espacios
 * por donde el usuario no puede transitar pero puede
 * ser destruida por bombas
 *
 * @author Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public class MuroRojo extends Celda {
    GestorImagenes gestor = new GestorImagenes();

    public MuroRojo() {
        ImageView imagen = gestor.getImagenMuroRojo();
        setImagenCelda(imagen);
        setTraspasable(false);
        setVisible(true);
        setTipo("MuroRojo");
    }
}
