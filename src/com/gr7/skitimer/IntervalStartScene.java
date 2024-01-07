	package com.gr7.skitimer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


class IntervalStartScene extends SceneWrapper {

	int interval;
	
	public IntervalStartScene(SceneManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene buildScene() {
		GridPane root = new GridPane();
		
		root.setPadding(new Insets(50, 50, 50, 50)); 
        root.setVgap(50); 
        root.setHgap(50);
        
        ChoiceBox<Integer> intervals = new ChoiceBox<>();
        intervals.getItems().addAll(15,30);
        intervals.getSelectionModel().selectedItemProperty().addListener(choiceListener);
        
        intervals.setValue(30);
        
        Button backButton = new Button("Tillbaka");
        backButton.setOnMouseClicked(event -> {
        	manager.setPrevious();
        });
        
        Button continueButton = new Button("Lägg till åkare");
        continueButton.setOnMouseClicked(event -> {
            next = new AddCompetitorScene(manager);
            builder.setInterval(interval);
            manager.setScene(next);
        });
        
        Label label = new Label("Individuell start");
        Label ivalLabel = new Label("Start-intervall");
        
        root.add(label, 0, 0);
        root.add(ivalLabel, 0, 1);
        root.add(intervals, 1, 1);
        root.add(backButton, 0, 3);
        root.add(continueButton, 0, 2);
        
		return new Scene(root, 500, 500);
	}
	
	ChangeListener<Integer> choiceListener = new ChangeListener<Integer>() {

		@Override
		public void changed(ObservableValue<? extends Integer> observable, Integer oldVal, Integer newVal) {
			interval = newVal;
			System.out.println(interval);
		}
	};

}
