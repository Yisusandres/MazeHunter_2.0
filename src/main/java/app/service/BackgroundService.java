package app.service;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BackgroundService {
    public static void setBackgroundFill(VBox root) {
        Color color = Color.rgb(26, 2, 43);
        BackgroundFill bgFill = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(bgFill);
        root.setBackground(background);
    }
}
