package laberinto.celdas;
import javafx.scene.image.ImageView;

/**
 * Variación visual del camino utilizada para simular radar o casillas de explosión.
 * * @author Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
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

