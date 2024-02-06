package ru.music.jplayer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MediaApp extends Application {

    private MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws MalformedURLException {

        PieChart chart = new PieChart();
        chart.getData().addAll(
                new PieChart.Data("Java", 20.0),
                new PieChart.Data("Python", 15.0),
                new PieChart.Data("JavaScript", 12.0),
                new PieChart.Data("C#", 10.0),
                new PieChart.Data("C++", 8.0),
                new PieChart.Data("Ruby", 5.0),
                new PieChart.Data("Other", 30.0));
        chart.setTitle("Programming Language Statistics");

        String location = "https://music.yandex.ru/home";
        WebView browser = new WebView();
        WebEngine engine = browser.getEngine();
        engine.load(location);

        Path path = Paths.get("mama-ya-popuz-yana.mp4");
        Media media = new Media(path.toUri().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        MediaView video = new MediaView(player);
        Button playButton = new Button("Play");
        Button pauseButton = new Button("Pause");
        Button stopButton = new Button("Stop");

        playButton.setOnAction(e -> mediaPlayer.play());
        pauseButton.setOnAction(e -> mediaPlayer.pause());
        stopButton.setOnAction(e -> mediaPlayer.stop());
        video.setOnError(ex -> System.out.println(ex));

        stage.setWidth(500);
        stage.setHeight(500);
        stage.setScene(new Scene(browser));
        stage.show();

        Stage stage2 = new Stage();
        stage2.setWidth(500);
        stage2.setHeight(500);
        stage2.setX(stage.getX() + stage.getWidth());
        stage2.setY(stage.getY());
        stage2.setScene(new Scene(chart));
        stage2.show();

        VBox box = new VBox(10, video, new HBox(10,  playButton, pauseButton, stopButton));
        box.setAlignment(Pos.CENTER);
        Stage stage3 = new Stage();
        stage3.setWidth(500);
        stage3.setHeight(500);
        stage3.setX(stage.getX());
        stage3.setY(stage.getY() + stage.getHeight());
        stage3.setScene(new Scene(box));
        stage3.show();


    }

}