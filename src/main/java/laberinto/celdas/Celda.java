package laberinto.celdas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Clase base que representa una unidad mínima dentro del tablero del laberinto.
 * Define propiedades comunes como imagen, traspasabilidad y visibilidad.
 * * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public class Celda{
    private ImageView imagenCelda;
    private boolean traspasable;
    private boolean visible;
    private String tipo;


    /**
     * Constructor por defecto. Inicializa la vista de imagen con dimensiones estándar de 40x40.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public Celda() {
        this.imagenCelda = new ImageView();
        this.imagenCelda.setFitWidth(40);
        this.imagenCelda.setFitHeight(40);
        this.imagenCelda.setPreserveRatio(true);
    }

    /**
     * Obtiene el componente visual de la celda.
     * @author Jesus Sifontes y Darwin Marcano
     * @return ImageView de la celda.
     */
    public ImageView getImagenCelda() {
        return imagenCelda;
    }


    /**
     * Configura el componente visual de la celda.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public void setImagenCelda(ImageView imagenCelda) {
        this.imagenCelda = imagenCelda;
    }

    /**
     * Configura la imagen en la celda con un tamanio especifico.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public void setImagenCelda(Image imagen) {
        if (this.imagenCelda == null) {
            this.imagenCelda = new ImageView();
        }
        this.imagenCelda.setImage(imagen);
        this.imagenCelda.setFitWidth(40);
        this.imagenCelda.setFitHeight(40);
        this.imagenCelda.setPreserveRatio(true);
    }

    /**
     * Define si una celda puede ser atravesada por el jugador.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public boolean isTraspasable() {
        return traspasable;
    }

    /**
     * Define la tangibilidad de una celda en especifico.
     * @author Jesus Sifontes y Darwin Marcano
     * @param traspasable true si es transitable, false si es un obstáculo.
     */
    public void setTraspasable(boolean traspasable) {
        this.traspasable = traspasable;
    }

    /**
     * Obtiene el identificador de tipo de la celda.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Obtiene el identificador de tipo de la celda.
     * @author Jesus Sifontes y Darwin Marcano
     * @return String con el nombre del tipo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el identificador de tipo de la celda.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
