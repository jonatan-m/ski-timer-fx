package com.gr7.skitimer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
	static Competition comp = new IntervalStart(Interval.THIRTY);
	
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
            	Competitor gunde = comp.getCompetitors().get("04");
            	long nanos = gunde.getStartTime().until(LocalTime.now(), ChronoUnit.NANOS);
            	
            	if(nanos < 0) {
            		long dayInNanos = (long)24 * 60 * 60 * 1000000000;
            		nanos += dayInNanos;
            	}
            	
            	var time = LocalTime.ofNanoOfDay(nanos);
                System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}