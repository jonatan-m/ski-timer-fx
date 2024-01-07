package com.gr7.skitimer;

import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddCompetitorScene extends SceneWrapper {

    private ListView<String> competitorListView;
    private TextField nameField;
    private TextField numberField;
    private Button addButton;
    private Button startCompetitionButton;
    private Label nameLabel;
    private Label numberLabel;
    private HashMap<String, String> competitors = new HashMap<>();

    public AddCompetitorScene(SceneManager manager) {
        super(manager);
    }

    @Override
    public Scene buildScene() {

        competitorListView = new ListView<>();

        nameField = new TextField();
        numberField = new TextField();

        nameLabel = new Label("Namn:");
        numberLabel = new Label("Åkarnummer:");

        addButton = new Button("Lägg till åkare");
        addButton.setOnAction(event -> addCompetitor());

        startCompetitionButton = new Button("Starta tävling");
        startCompetitionButton.setOnAction(event -> startCompetition());

        nameField.textProperty().addListener((observable, oldValue, newValue) -> handleNameChanged(newValue));
        numberField.textProperty().addListener((observable, oldValue, newValue) -> handleNumberChanged(newValue));

        Button backButton = new Button("Tillbaka");
        backButton.setOnAction(event -> {
        	manager.setPrevious();
        });
        
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(50, 50, 50, 50)); 
        layout.setVgap(20); 
        layout.setHgap(20);
        
        
        layout.add(competitorListView, 0, 0, 2, 1);
        layout.add(nameLabel, 0, 1);
        layout.add(nameField, 1, 1);
        layout.add(numberLabel, 0, 2);
        layout.add(numberField, 1, 2);
        layout.add(addButton, 0, 3);
        layout.add(startCompetitionButton, 1, 3);
        layout.add(backButton, 0, 4);

        return new Scene(layout, 500, 500);
    }

    private void handleSelectedCompetitor(String selectedCompetitor) {
        System.out.println("Vald åkare: " + selectedCompetitor);
    }

    private void handleNameChanged(String newName) {
        System.out.println("Nytt namn: " + newName);
    }

    private void handleNumberChanged(String newNumber) {
        System.out.println("Nytt åkarnummer: " + newNumber);
    }

    private void addCompetitor() {
        String name = nameField.getText();
        String number = numberField.getText();
        
        builder.addCompetitor(number, name);
        
        String tmp = competitors.put(number, name);
        
        if(tmp != null) {
        	competitorListView.getItems().clear();
        	competitors.forEach((k,v) -> {
        		competitorListView.getItems().add("Åkare " + v + " - Nummer " + k);
        	});
        }
        else {
        	competitorListView.getItems().add("Åkare " + name + " - Nummer " + number);        	
        }
        

        nameField.clear();
        numberField.clear();
    }

    private void startCompetition() {
    	competition = builder.build();
    	
    	competition.getCompetitors().forEach((k,v) -> {
    		System.out.println(v.getStartTime());
    	});
        System.out.println("Tävlingen har startat!");
        
        next = new TimerScene(manager);
        manager.setScene(next);
    }
}

