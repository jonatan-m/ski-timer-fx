package com.gr7.skitimer;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import java.time.LocalTime;

public class TimerScene extends SceneWrapper {
    private RadioButton intermediateTimeRadio;
    private RadioButton finishTimeRadio;
    boolean isFinishTime = false;
   

    public TimerScene(SceneManager manager) {
        super(manager);
        

        intermediateTimeRadio = new RadioButton("Mellantid");
        finishTimeRadio = new RadioButton("Målgångstid");
        ToggleGroup toggleGroup = new ToggleGroup();
        intermediateTimeRadio.setToggleGroup(toggleGroup);
        finishTimeRadio.setToggleGroup(toggleGroup);
       
    }

    @Override
    public Scene buildScene() {
        GridPane root = new GridPane();

        root.setPadding(new Insets(50, 50, 50, 50));
        root.setVgap(50);
        root.setHgap(50);
        
        intermediateTimeRadio.setOnAction(event -> {
        	isFinishTime = false;
        });
        
        finishTimeRadio.setOnAction(event -> {
        	isFinishTime = true;
        });

        Label inputLabel = new Label("Åkarenummer:");
        ChoiceBox<String> competitors = new ChoiceBox<>();
        
        competition.getCompetitors().forEach((k,v) -> {
        	competitors.getItems().add(k);
        });
        
        competitors.setValue(competitors.getItems().get(0));
        
        Button stopButton = new Button("Klocka åkare");
        Label competitorLabel = new Label();
        Label resultLabel = new Label();
        Button backButton = new Button("Tillbaka");
        Label allFinished = new Label("Alla åkare har gått i mål");
        Button toResult = new Button("Resultat");

        root.add(inputLabel, 0, 0);
        root.add(competitors, 1, 0);
        root.add(stopButton, 0, 2);
        root.add(intermediateTimeRadio, 0, 1);
        root.add(finishTimeRadio, 1, 1);
        root.add(competitorLabel, 0, 4);
        root.add(resultLabel, 1, 4, 2, 1);
        root.add(backButton, 0, 5);

        toResult.setOnAction(event -> {
        	manager.setScene(new FinishScene(manager));
        });
       

        stopButton.setOnAction(event -> {
        	try {
        		Competitor competitor = competition.getCompetitors().get(competitors.getValue());
        		LocalTime time = Timer.stopTimer(competitor.getStartTime());
        		
        		competitorLabel.setText(competitor.getSkierNumber() + ":" + competitor.getSkierName());
        		resultLabel.setText(time.toString());
        		
        		competition.finishCompetitor(competitors.getValue(), time);
        		
        		if(competition.isFinished) {
        			competition.endCompetition();
        			root.getChildren().remove(0, 5);
        			root.add(allFinished, 0, 0);
        			root.add(toResult, 0, 1);
        		}
        	}catch(NullPointerException e) {
        		resultLabel.setText("Ingen åkare med det numret");
        	}
        });

        backButton.setOnAction(event -> {
            manager.setPrevious();
        });

        return new Scene(root, 500, 500);
    }

  
}
