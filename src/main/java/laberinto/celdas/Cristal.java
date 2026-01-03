package laberinto.celdas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Clase que hereda de celda y representa la
 * puntuación del usuario en el laberinto.
 * @author Juan Meneses
 * @version 22.0.2
 * @since 01-11-2025
 */

public class Cristal extends Celda {
    private int valor;
    GestorImagenes gestor = new GestorImagenes();
    public Cristal(int valor){
        this.valor = valor;
        ImageView imagen = gestor.getImagenCristal();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        setTipo("Cristal");
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
