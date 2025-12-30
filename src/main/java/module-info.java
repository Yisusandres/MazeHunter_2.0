module com.view.mazehunterapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens app.controller to javafx.fxml;
    exports app.controller;
    opens app to javafx.fxml;
    exports app;

}