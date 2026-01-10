package laberinto.celdas;
import javafx.scene.image.ImageView;

/**
 * Clase que hereda de Celda y pertenece a
 * laberinto.
 * @author Juan Meneses
 * @version 22.0.2
 * @since 01-11-2025
 */
public class CaminoConPunto extends Celda {
    GestorImagenes gestor = new GestorImagenes();
    public CaminoConPunto() {
        ImageView imagen = gestor.getImagenCaminoConPunto();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        setTipo("CaminoConPunto");
    }
}

