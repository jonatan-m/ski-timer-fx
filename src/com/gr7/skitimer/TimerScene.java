package com.gr7.skitimer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimerScene extends SceneWrapper {

    public TimerScene(SceneManager manager, Competition competition) {
        super(manager);
        this.competition = competition;
    }

    @Override
    public Scene buildScene() {
        GridPane root = new GridPane();

        root.setPadding(new Insets(50, 50, 50, 50));
        root.setVgap(50);
        root.setHgap(50);

        Label label = new Label("Timer Scene");

        Label timeLabel = new Label("00:00:00");

        Button startButton = new Button("Starta Tävling");
        startButton.setOnAction(startButtonHandler);

        Button stopButton = new Button("Stoppa Tävling");
        stopButton.setOnAction(stopButtonHandler);

        Button backButton = new Button("Tillbaka");
        backButton.setOnMouseClicked(event -> manager.setPrevious());

        root.add(label, 0, 0);
        root.add(timeLabel, 0, 1);
        root.add(startButton, 0, 2);
        root.add(stopButton, 0, 3);
        root.add(backButton, 0, 4);

        return new Scene(root, 500, 500);
    }

    EventHandler<ActionEvent> startButtonHandler = event -> {
        LocalTime startTime = Timer.getTime();
        LocalTime resultTime = Timer.stopTimer(startTime);
        System.out.println("Tävling startad: " + startTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("Tidtagning: " + resultTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
    };

    EventHandler<ActionEvent> stopButtonHandler = event -> {
        LocalTime stopTime = Timer.getTime();
        LocalTime resultTime = Timer.stopTimer(competition.competitors.get("Skier1").getStartTime());
        System.out.println("Tävling stoppad: " + stopTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("Total tid: " + resultTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
    };
}

