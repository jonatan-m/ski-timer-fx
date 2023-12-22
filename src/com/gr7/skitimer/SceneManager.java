package com.gr7.skitimer;

import java.util.Stack;

import javafx.scene.Scene;
import javafx.stage.Stage;

class SceneManager {
	private Stage stage;
	private Stack<SceneWrapper> sceneStack = new Stack<>();
	private SceneWrapper current;
	private StartScreen start = new StartScreen(this);
	
	public SceneManager(Stage stage) {
		this.stage = stage;
		sceneStack.push(start);
	}
	
	public void setPrevious() {
		SceneWrapper prev = sceneStack.pop();
		stage.setScene(prev.buildScene());
		current = prev;
	}
	
	public void setScene(SceneWrapper nextScene) {
		sceneStack.push(current);
		current = nextScene;
		stage.setScene(nextScene.buildScene());
	}

}
