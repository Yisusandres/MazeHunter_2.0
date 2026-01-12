package laberinto.celdas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;
/**
 * Clase encargada de la carga y gestión de los recursos gráficos (imágenes) para las celdas y personajes del laberinto.
 * @author Jesus Sifontes
 * @version 22.0.2
 * @since 11-01-2026
*/
public class GestorImagenes {
    /**
     * Almacena la ruta del archivo de imagen del personaje seleccionado.
     * @author Jesus Sifontes
     */
    private static String rutaPersonaje;


    /**
     * Obtiene la ruta actual de la imagen del personaje.
     * @author Jesus Sifontes
     */
    public static String getRutaPersonaje() {
        return rutaPersonaje;
    }

    /**
     * Establece la ruta de la imagen que se utilizará para el personaje.
     * @author Jesus Sifontes
     * @param rutaPersonaje Ruta del archivo de imagen.
     */
    public static void setRutaPersonaje(String rutaPersonaje) {
        GestorImagenes.rutaPersonaje = rutaPersonaje;
    }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de camino estándar.
     * @author Jesus Sifontes
     * @return ImageView con la imagen del camino.
     */
    public ImageView getImagenCamino() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/camino.png"))));
    }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de camino con punto.
     * @author Jesus Sifontes
     * @return ImageView con la imagen del camino con punto.
     */
    public ImageView getImagenCaminoConPunto() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/caminoConPunto.png"))));
    }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de cristal.
     * @author Jesus Sifontes
     * @return ImageView con la imagen del cristal.
     */
    public ImageView getImagenCristal() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/cristal.png"))));
    }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de muro estándar.
     * @author Jesus Sifontes
     * @return ImageView con la imagen del camino.
     */
    public ImageView getImagenMuro() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/muroGris.png"))));
    }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de muro rojo.
     * @author Jesus Sifontes
     * @return ImageView con la imagen del camino.
     */
    public ImageView getImagenMuroRojo() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/muroRojo.png"))));
    }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de jugador.
     * @author Jesus Sifontes
     * @return ImageView con la imagen del jugador.
     */
    public ImageView getImagenJugador() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/personajes/personajeWito.png"))));
    }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de vida extra.
     * @author Jesus Sifontes
     * @return ImageView con la imagen vida extra.
     */
    public ImageView getImagenVidaExtra() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/vidaExtra.png"))));
    }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de trampa.
     * @author Jesus Sifontes
     * @return ImageView con la imagen de trampa.
     */
    public ImageView getImagenTrampa() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/trampa.png"))));
    }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de salida.
     * @author Jesus Sifontes
     * @return ImageView con la imagen del camino.
     */
    public ImageView getImagenSalida() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/salida.png"))));
    }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de llave.
     * @author Jesus Sifontes
     * @return ImageView con la imagen de llave.
     */
   public ImageView getImagenLlave() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/llave.png"))));
   }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de bomba.
     * @author Jesus Sifontes
     * @return ImageView con la imagen de bomba.
     */
   public ImageView getImagenBomba() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/bomba.png"))));
   }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de energia.
     * @author Jesus Sifontes
     * @return ImageView con la imagen de la energia.
     */
    public ImageView getImagenEnergia() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/energia.png"))));
    }

    /**
     * Carga y devuelve la imagen correspondiente a una celda de llave de explosion.
     * @author Jesus Sifontes
     * @return ImageView con la imagen de la llave de explosion.
     */
    public ImageView getImagenLlaveDeExplosion() {
        return new ImageView(new Image(Objects.requireNonNull(GestorImagenes.class.getResourceAsStream("/imagenes/celdas/llaveDeExplosion.png"))));
    }
}
