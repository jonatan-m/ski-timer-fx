package com.gr7.skitimer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
 
public class App extends Application {
	static Competition comp;
	private SceneManager sceneManager;
	
    public static void main(String[] args) {
   
        launch(args);
        
        System.out.println("Exiting");
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