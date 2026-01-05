package laberinto.celdas;

import javafx.scene.image.ImageView;

public class Energia extends Celda {
    GestorImagenes gestor = new GestorImagenes();
    public Energia() {
        ImageView imagen = gestor.getImagenEnergia();
        setImagenCelda(imagen);
        setTraspasable(true);
        setVisible(true);
        setTipo("Energia");
    }
}
