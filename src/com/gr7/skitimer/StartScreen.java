package com.gr7.skitimer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;

class StartScreen extends SceneWrapper{
	
	String competitionType;
	
	public StartScreen(SceneManager manager) {
		super(manager);
	}
	
	@Override
	public Scene buildScene() {
		GridPane root = new GridPane();
		
		root.setPadding(new Insets(50, 50, 50, 50)); 
        root.setVgap(50); 
        root.setHgap(50);
        
        ChoiceBox<String> competitionTypes = new ChoiceBox<>();
        competitionTypes.getItems()
        	.addAll("Mass start", "Individuell start", "Jaktstart");
        competitionTypes.getSelectionModel().selectedItemProperty().addListener(choiceListener);
        
        Button btn = new Button();
        btn.setText("Välj Tävling");
        btn.setOnAction(btnHandler);
        
        root.add(competitionTypes, 0, 0);
        root.add(btn, 0,1);
        
        return new Scene(root, 500, 500);
	}
	
	
	EventHandler<ActionEvent> btnHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			switch(competitionType) {
			case "Mass start" -> next = new MassStartScene(manager);
			case "Individuell start" -> next = new IntervalStartScene(manager);
 			}
			
			manager.setScene(next);
		}
		
	};
	
	ChangeListener<String> choiceListener = new ChangeListener<String>() {

		@Override
		public void changed(
				ObservableValue<? extends String> observable, String oldValue, String newValue) {
			competitionType = newValue;
			
		}
		
	};

}
