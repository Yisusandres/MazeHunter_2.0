package laberinto.celdas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class GestorImagenes {
    private static String rutaPersonaje;

    public static String getRutaPersonaje() {
        return rutaPersonaje;
    }

    public static void setRutaPersonaje(String rutaPersonaje) {
        GestorImagenes.rutaPersonaje = rutaPersonaje;
    }

    public ImageView getImagenCamino() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/camino.png"))));
    }

    public ImageView getImagenCaminoConPunto() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/caminoConPunto.png"))));
    }

    public ImageView getImagenCristal() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/cristal.png"))));
    }

    public ImageView getImagenMuro() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/muroGris.png"))));
    }

    public ImageView getImagenMuroRojo() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/muroRojo.png"))));
    }

    public ImageView getImagenJugador() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/personajes/personajeWito.png"))));
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

   public ImageView getImagenBomba() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/bomba.png"))));
   }

    public ImageView getImagenEnergia() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/energia.png"))));
    }
}
