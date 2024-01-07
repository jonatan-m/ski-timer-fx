package com.gr7.skitimer;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

class FinishScene extends SceneWrapper {

	private int pos = 1;
	public FinishScene(SceneManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene buildScene() {
		GridPane root = new GridPane();

        root.setPadding(new Insets(50, 50, 50, 50));
        root.setVgap(50);
        root.setHgap(50);
        
        
        Label title = new Label("Resultat");
        
        root.add(title, 0, 0);
        
        competition.getResult().getResults().forEach((k,v) -> {
        	Label result = new Label();
        	result.setText(pos + ": " 
        			+ v.getSkierNumber() + " " 
        			+ v.getSkierName() + " Tid: " + v.getFinishTime());
        	
        	root.add(result, 0, pos);
        	++pos;
        });
        
		return new Scene(root, 500, 500);
	}

}
