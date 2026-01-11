package laberinto.celdas;
import javafx.scene.image.ImageView;

/**
 * Clase que hereda de Celda y es la clave
 * para salir del laberinto y ganar.
 * @author Juan Meneses
 * @version 22.0.2
 * @since 01-11-2025
 */
public class LLaveDeExplosion extends Celda {
    boolean encontrada;
    GestorImagenes gestor = new GestorImagenes();
    public LLaveDeExplosion(){
        ImageView imagen = gestor.getImagenLlaveDeExplosion();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        encontrada = false;
        setTipo("LlaveDeExplosion");
    }

    public boolean isEncontrada() {
        return encontrada;
    }

    public void setEncontrada(boolean encontrada) {
        this.encontrada = encontrada;
    }
}
