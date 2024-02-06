package ru.music.jplayer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class MediaPlayerApp extends Application {

    private MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws MalformedURLException {
        // Указываем путь к медиа-файлу

        File mediaFile = new File("mama-ya-popuz-yana.mp4");
        Media media = new Media(mediaFile.toURI().toURL().toString());
        mediaPlayer = new MediaPlayer(media);

        // Создаем компоненты управления
        MediaView mediaView = new MediaView(mediaPlayer);
        Button playButton = new Button("Play");
        Button pauseButton = new Button("Pause");
        Button stopButton = new Button("Stop");

        // Добавляем обработчики событий для кнопок
        playButton.setOnAction(e -> mediaPlayer.play());
        pauseButton.setOnAction(e -> mediaPlayer.pause());
        stopButton.setOnAction(e -> mediaPlayer.stop());

        // Размещаем компоненты в горизонтальной панели
        HBox controlBox = new HBox(10, playButton, pauseButton, stopButton);
        HBox.setMargin(playButton, new javafx.geometry.Insets(10, 10, 10, 10));

        // Размещаем компоненты на сцене
        HBox root = new HBox(10, mediaView, controlBox);
        Scene scene = new Scene(root, 1500, 700);

        // Настройка и отображение окна
        primaryStage.setTitle("Media Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        // Освобождаем ресурсы при завершении приложения
        if (mediaPlayer != null) {
            mediaPlayer.dispose();
        }
    }
}
