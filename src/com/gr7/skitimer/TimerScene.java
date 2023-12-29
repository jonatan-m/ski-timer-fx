package com.gr7.skitimer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.util.Duration;

import java.time.LocalTime;
import java.util.HashMap;

public class TimerScene extends SceneWrapper {
    private Timer timer;
    private HashMap<String, LocalTime> startTimes = new HashMap<>();
    private LocalTime startTime;
    private RadioButton intermediateTimeRadio;
    private RadioButton finishTimeRadio;
    private Label timerLabel;
    private Timeline timeline;

    public TimerScene(SceneManager manager) {
        super(manager);
        this.timer = new Timer();

        intermediateTimeRadio = new RadioButton("Mellantid");
        finishTimeRadio = new RadioButton("Målgångstid");
        ToggleGroup toggleGroup = new ToggleGroup();
        intermediateTimeRadio.setToggleGroup(toggleGroup);
        finishTimeRadio.setToggleGroup(toggleGroup);

        timerLabel = new Label("Tid: 00:00:00");

       
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTimer()));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    @Override
    public Scene buildScene() {
        GridPane root = new GridPane();

        root.setPadding(new Insets(50, 50, 50, 50));
        root.setVgap(50);
        root.setHgap(50);

        Label inputLabel = new Label("Åkarenummer:");
        TextField inputField = new TextField();
        Button startButton = new Button("Starta tidtagning");
        Button stopButton = new Button("Stoppa tidtagning");
        Label resultLabel = new Label();
        Button backButton = new Button("Tillbaka");

        root.add(inputLabel, 0, 0);
        root.add(inputField, 1, 0);
        root.add(startButton, 0, 1);
        root.add(stopButton, 1, 1);
        root.add(intermediateTimeRadio, 0, 2);
        root.add(finishTimeRadio, 1, 2);
        root.add(timerLabel, 0, 3, 2, 1);
        root.add(resultLabel, 0, 4, 2, 1);
        root.add(backButton, 0, 5);

        startButton.setOnAction(event -> {
            try {
                int skiernumber = Integer.parseInt(inputField.getText().trim());
                startTime = timer.getTime();
                startTimes.put(String.valueOf(skiernumber), startTime);
                resultLabel.setText("Tidtagning påbörjad för åkarenummer " + skiernumber);
                timeline.play(); 
            } catch (NumberFormatException e) {
                resultLabel.setText("Ogiltigt åkarenummer.");
            }
        });

        stopButton.setOnAction(event -> {
            try {
                int skiernumber = Integer.parseInt(inputField.getText().trim());

                if (startTimes.containsKey(String.valueOf(skiernumber))) {
                    LocalTime endTime = timer.getTime();
                    LocalTime duration;

                    if (intermediateTimeRadio.isSelected()) {
                        duration = calculateDuration(startTimes.get(String.valueOf(skiernumber)), endTime);
                    } else {
                        duration = Timer.stopTimer(startTimes.get(String.valueOf(skiernumber)));
                    }

                    resultLabel.setText("Tid för åkarenummer " + skiernumber + ": " + duration.toString());
                    timeline.stop(); 
                } else {
                    resultLabel.setText("Starttid ej hittad för åkarenummer " + skiernumber);
                }
            } catch (NumberFormatException e) {
                resultLabel.setText("Ogiltigt åkarenummer.");
            }
        });

        backButton.setOnAction(event -> {
            manager.setPrevious();
            timeline.stop(); 
        });

        return new Scene(root, 500, 500);
    }

    private LocalTime calculateDuration(LocalTime startTime, LocalTime endTime) {
        return LocalTime.ofSecondOfDay(startTime.until(endTime, java.time.temporal.ChronoUnit.SECONDS));
    }

    private void updateTimer() {
        LocalTime currentTime = timer.getTime();
        long elapsedSeconds = startTime.until(currentTime, java.time.temporal.ChronoUnit.SECONDS);
        timerLabel.setText("Tid: " + formatTime(elapsedSeconds));
    }

    private String formatTime(long elapsedSeconds) {
        long hours = elapsedSeconds / 3600;
        long minutes = (elapsedSeconds % 3600) / 60;
        long seconds = elapsedSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
