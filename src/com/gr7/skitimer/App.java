package com.gr7.skitimer;

import java.io.File;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Stack;

import jakarta.xml.bind.JAXBContext;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
	static Competition comp;
	private SceneManager sceneManager;
	
    public static void main(String[] args) {
   
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	sceneManager = new SceneManager(primaryStage);
        primaryStage.setTitle("SkiTimer");
        
        sceneManager.setPrevious();;
        primaryStage.show();
    }
    
    EventHandler<ActionEvent> btnHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent arg0) {
			
		}
    };
}