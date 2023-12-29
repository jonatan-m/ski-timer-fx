package com.gr7.skitimer;

import java.time.LocalTime;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TimerScene extends SceneWrapper {
    private Timer timer;

    public TimerScene(SceneManager manager) {
        super(manager);
        this.timer = new Timer();
    }

    @Override
    public Scene buildScene() {
        GridPane root = new GridPane();

        root.setPadding(new Insets(50, 50, 50, 50));
        root.setVgap(50);
        root.setHgap(50);

        Label inputLabel = new Label("Åkarenummer:");
        TextField inputField = new TextField();
        Button calculateButton = new Button("Beräkna tid");
        Label resultLabel = new Label();

        calculateButton.setOnAction(event -> {
            try {
                int skiernumber = Integer.parseInt(inputField.getText().trim());
                LocalTime endTime = timer.getTime();
                LocalTime duration = timer.stopTimer();
                resultLabel.setText("Tid för åkarenummer " + skiernumber + ": " + duration.toString());
            } catch (NumberFormatException e) {
                resultLabel.setText("Ogiltigt åkarenummer.");
            }
        });

        root.add(inputLabel, 0, 0);
        root.add(inputField, 1, 0);
        root.add(calculateButton, 0, 1);
        root.add(resultLabel, 1, 1);

        return new Scene(root, 500, 500);
    }
}


