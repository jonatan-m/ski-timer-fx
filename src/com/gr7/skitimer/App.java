package com.gr7.skitimer;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
	static Competition comp = new Competition(StartFormat.INTERVAL);
	
    public static void main(String[] args) {
    	comp.addCompetitor("Shakur", "04");
    	comp.addCompetitor("Fredde", "02");
    	comp.addCompetitor("Jonte", "01");
    	comp.addCompetitor("Lars", "03");
    	
    	comp.setStartTimes(LocalTime.of(10, 0, 0));
    	
   
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!!");
        Button btn = new Button();
        btn.setText("Ta tid åkare 01");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	Competitor gunde = comp.getCompetitors().get("01");
            	long seconds = gunde.getStartTime().until(LocalTime.now(), ChronoUnit.SECONDS);
            	
            	var time = LocalTime.ofSecondOfDay(seconds);
                System.out.println(time.toString().formatted("hh:mm:ss"));
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}