package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de Celda y es la clave
 * para salir del laberinto y ganar.
 * @author Juan Meneses
 * @version 22.0.2
 * @since 01-11-2025
 */
public class LLave extends Celda {
    boolean encontrada;
    GestorImagenes gestor = new GestorImagenes();
    public LLave(){
        ImageView imagen = gestor.getImagenLlave();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        encontrada = false;
        setTipo("Llave");
    }

    public boolean isEncontrada() {
        return encontrada;
    }

    public void setEncontrada(boolean encontrada) {
        this.encontrada = encontrada;
    }
}
