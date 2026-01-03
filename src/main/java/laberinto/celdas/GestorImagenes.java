package laberinto.celdas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class GestorImagenes {

    public ImageView getImagenCamino() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/camino.png"))));
    }

    public ImageView getImagenCristal() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/cristal.png"))));
    }

    public ImageView getImagenMuro() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/muroGris.png"))));
    }

    public ImageView getImagenJugador() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/personajePacman.png"))));
    }

    public ImageView getImagenVidaExtra() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/vidaExtra.png"))));
    }

    public ImageView getImagenTrampa() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/trampa.png"))));
    }

    public ImageView getImagenSalida() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/salida.png"))));
    }

   public ImageView getImagenLlave() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/llave.png"))));
   }
}
