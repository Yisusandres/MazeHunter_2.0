package laberinto.celdas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Celda{
    private ImageView imagenCelda;
    private boolean traspasable;
    private boolean visible;
    private String tipo;


    public Celda() {
        this.imagenCelda = new ImageView();
        this.imagenCelda.setFitWidth(40);
        this.imagenCelda.setFitHeight(40);
        this.imagenCelda.setPreserveRatio(true);
    }

    public ImageView getImagenCelda() {
        return imagenCelda;
    }

    public void setImagenCelda(ImageView imagenCelda) {
        this.imagenCelda = imagenCelda;
    }

    public void setImagenCelda(Image imagen) {
        if (this.imagenCelda == null) {
            this.imagenCelda = new ImageView();
        }
        this.imagenCelda.setImage(imagen);
        this.imagenCelda.setFitWidth(40);
        this.imagenCelda.setFitHeight(40);
        this.imagenCelda.setPreserveRatio(true);
    }

    public boolean isTraspasable() {
        return traspasable;
    }

    public void setTraspasable(boolean traspasable) {
        this.traspasable = traspasable;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
