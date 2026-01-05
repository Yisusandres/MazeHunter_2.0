package laberinto.celdas;

import javafx.scene.image.ImageView;

public class Bomba extends Celda {
    GestorImagenes gestor = new GestorImagenes();
    public Bomba() {
        ImageView imagen = gestor.getImagenBomba();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        setTipo("Bomba");
    }
}
