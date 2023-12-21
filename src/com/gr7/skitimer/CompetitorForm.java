package com.gr7.skitimer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map.Entry;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

class CompetitorForm {
	
	//Creating a Grid Pane 
    GridPane gridPane = new GridPane();
    String competitor;
    
    public CompetitorForm(Competition competition) {
    	
    	gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        gridPane.setVgap(50); 
        gridPane.setHgap(50);       
        gridPane.setAlignment(Pos.CENTER); 
    	
    	ChoiceBox<String> choices = new ChoiceBox<>(); 
    	for(Entry<String, Competitor> e : competition.getCompetitors().entrySet()) {
    		choices.getItems().add(e.getKey());
    	}
        
        choices.setMinWidth(100);
        //choices.setScaleX(3.0);
        
        choices.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println(choices.getValue());
				competitor = choices.getValue();
				
			}
        	
        });
        
        Label label = new Label();
        label.setText("Åkare");
        label.setScaleX(2.0);
        label.setScaleY(2.0);
        
        Label time = new Label("00:00:00");
        Label timeLabel = new Label("Tid");
        
        Button b1 = new Button();
        b1.setText("Klocka Åkare");
        
        b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				LocalTime start = competition.competitors.get(competitor).getStartTime();
				time.setText(
						Timer.stopTimer(start)
						.format(DateTimeFormatter.ISO_LOCAL_TIME)
						.toString());
			}
        	
        });
        
        gridPane.add(label, 0, 0);
    	gridPane.add(choices, 1, 0);
    	gridPane.add(b1, 0, 2);
    	gridPane.add(timeLabel, 0, 3);
    	gridPane.add(time, 1, 3);
    }
    

	public Scene getScene() {
		return new Scene(gridPane, 600, 600);
	}

}
