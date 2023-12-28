package com.gr7.skitimer;

import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

class PursuitStartScene extends SceneWrapper {
	
	File result;

	public PursuitStartScene(SceneManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene buildScene() {
		GridPane root = new GridPane();
		
		root.setPadding(new Insets(50, 50, 50, 50)); 
        root.setVgap(50); 
        root.setHgap(50);
        
        Label fileName = new Label("Ingen fil vald");
        
        Button confirm = new Button("Välj fil");
        confirm.setOnMouseClicked(event -> {
        	result = manager.openFileChooser();
        	fileName.setText(result != null ? result.getName() : "Ingen fil vald");
        });
        
        Button backButton = new Button("Tillbaka");
        backButton.setOnMouseClicked(event -> {
        	manager.setPrevious();
        });
        
        Label label = new Label("Jaktstart");
        
        
        
        root.add(label, 0, 0);
        root.add(confirm, 0, 1);
        root.add(fileName, 1, 1);
        root.add(backButton, 0, 2);
        
		return new Scene(root, 500, 500);
	}

}
