package com.gr7.skitimer;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MassStartScene extends SceneWrapper {

	public MassStartScene(SceneManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene buildScene() {
		GridPane root = new GridPane();
		
		root.setPadding(new Insets(50, 50, 50, 50)); 
        root.setVgap(50); 
        root.setHgap(50);
        
        Button backButton = new Button("Tillbaka");
        backButton.setOnMouseClicked(event -> {
        	manager.setPrevious();
        });
        
        Label label = new Label("Mass-start");
        
        root.add(label, 0, 0);
        
        root.add(backButton, 0, 1);
        
		return new Scene(root, 500, 500);
	}

}
