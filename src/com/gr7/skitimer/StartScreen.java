package com.gr7.skitimer;

import java.time.LocalTime;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

class StartScreen extends SceneWrapper{
	
	String competitionType;
	String hour;
	String minute;
	
	public StartScreen(SceneManager manager) {
		super(manager);
	}
	
	@Override
	public Scene buildScene() {
		GridPane root = new GridPane();
		
		root.setPadding(new Insets(50, 50, 50, 50)); 
        root.setVgap(50); 
        root.setHgap(50);
        
        
        
        Label label = new Label("Välj typ av tävling");
        
        ChoiceBox<String> competitionTypes = new ChoiceBox<>();
        competitionTypes.getItems()
        	.addAll("Masstart", "Individuell start", "Jaktstart");
        competitionTypes.getSelectionModel().selectedItemProperty().addListener(choiceListener);
        competitionTypes.setValue(competitionTypes.getItems().get(0));
        
        
        Label timeLabel = new Label("Välj starttid");
        
        ChoiceBox<String> hours = new ChoiceBox<>();
        hours.getItems().addAll("00", "01", "02", "03", "04", "05", "06", "07",
        		"08", "09", "10", "11", "12", "13", "14", "15", "16", "17",
        		"18", "19", "20", "21", "22", "23");
        hours.getSelectionModel().selectedItemProperty().addListener(hourListener);
        hours.setValue(hours.getItems().get(0));
        
        ChoiceBox<String> minutes = new ChoiceBox<>();
        minutes.getItems().addAll("00", "05", "10", "15", "20", "25", "30", "35",
        		"40", "45", "50", "55");
        minutes.getSelectionModel().selectedItemProperty().addListener(minuteListener);
        minutes.setValue(minutes.getItems().get(0));
        
        Button btn = new Button();
        btn.setText("Fortsätt");
        btn.setOnAction(btnHandler);
        
        Button exit = new Button("Avsluta");
        exit.setOnMouseClicked(event -> {
        	manager.killStage();
        });
        
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        
        root.add(label, 0, 0);
        root.add(competitionTypes, 1, 0);
        root.add(timeLabel, 0, 1);
        pane.add(hours, 0, 0);
        pane.add(minutes, 1, 0);
        root.add(btn, 0,2);
        root.add(exit, 0, 3);
        
        root.add(pane, 1, 1);
        
        return new Scene(root, 500, 500);
	}
	
	
	EventHandler<ActionEvent> btnHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			switch(competitionType) {
			case "Masstart" -> next = new MassStartScene(manager);
			case "Individuell start" -> next = new IntervalStartScene(manager);
			case "Jaktstart" -> next = new PursuitStartScene(manager);
 			}
			
			LocalTime startTime = LocalTime.parse(hour + ":" + minute + ":" + "00");
			System.out.println(startTime);
			builder.setStartTime(startTime);
			manager.setScene(next);
		}
		
	};
	
	ChangeListener<String> choiceListener = new ChangeListener<String>() {

		@Override
		public void changed(
				ObservableValue<? extends String> observable, String oldValue, String newValue) {
			System.out.println(newValue);
			competitionType = newValue;
			
		}
		
	};
	
	ChangeListener<String> hourListener = new ChangeListener<String>() {

		@Override
		public void changed(
				ObservableValue<? extends String> observable, String oldValue, String newValue) {
			System.out.println(newValue);
			hour = newValue;
			
		}
		
	};
	
	ChangeListener<String> minuteListener = new ChangeListener<String>() {

		@Override
		public void changed(
				ObservableValue<? extends String> observable, String oldValue, String newValue) {
			System.out.println(newValue);
			minute = newValue;
			
		}
		
	};

}
