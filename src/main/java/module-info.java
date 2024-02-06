module ru.music.jplayer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires javafx.media;

    opens ru.music.jplayer to javafx.fxml;
    exports ru.music.jplayer;
}