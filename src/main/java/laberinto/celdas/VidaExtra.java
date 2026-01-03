package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de Celda y su función es
 * sumarle vida al personaje del usuario en
 * el laberinto.
 *
 * @author Juan Meneses
 * @version 22.0.2
 * @since 01-11-2025
 */

public class VidaExtra extends Celda {
    private int valor;
    GestorImagenes gestor = new GestorImagenes();

    public VidaExtra(int valor){
        ImageView imagen = gestor.getImagenVidaExtra();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        setValor(valor);
        setTipo("Vida");
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
