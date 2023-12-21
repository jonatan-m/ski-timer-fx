package com.gr7.skitimer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CompetitorForm {
	
	//Creating a Grid Pane 
    GridPane gridPane = new GridPane();  
    
    public CompetitorForm() {
    	
    	gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        gridPane.setVgap(50); 
        gridPane.setHgap(50);       
        gridPane.setAlignment(Pos.CENTER); 
    	
    	ChoiceBox<String> choices = new ChoiceBox<>(); 
        choices.getItems().addAll
           ("01", "02", "03", "04", "05"); 
        
        choices.setMinWidth(100);
        //choices.setScaleX(3.0);
        
        choices.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println(choices.getValue());
				
			}
        	
        });
        
        Label label = new Label();
        label.setText("Åkare");
        label.setScaleX(2.0);
        label.setScaleY(2.0);
        
        Button b1 = new Button();
        b1.setText("Klocka Åkare");
        //b1.setScaleX(2.0);
        //b1.setScaleY(2.0);
        
        gridPane.add(label, 0, 0);
    	gridPane.add(choices, 1, 0);
    	gridPane.add(b1, 0, 3);
    }
    

	public Scene getScene() {
		return new Scene(gridPane, 800, 800);
	}

}
