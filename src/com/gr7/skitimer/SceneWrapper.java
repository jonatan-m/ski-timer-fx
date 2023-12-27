package com.gr7.skitimer;

import javafx.scene.Scene;

abstract class SceneWrapper {
	protected SceneManager manager;
	protected SceneWrapper next;
	protected Competition competition;
	protected static CompetitionBuilder builder = new CompetitionBuilder();

	public SceneWrapper(SceneManager manager) {
		this.manager = manager;
	}
	
	public abstract Scene buildScene();
	
	
	public void setPrevious() {
		manager.setPrevious();
	}

}
