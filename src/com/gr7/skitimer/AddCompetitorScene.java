package com.gr7.skitimer;

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

        GridPane layout = new GridPane();
        layout.add(competitorListView, 0, 0, 2, 1);
        layout.add(nameLabel, 0, 1);
        layout.add(nameField, 1, 1);
        layout.add(numberLabel, 0, 2);
        layout.add(numberField, 1, 2);
        layout.add(addButton, 1, 3);
        layout.add(startCompetitionButton, 1, 4);

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

        competitorListView.getItems().add("Åkare " + name + " - Nummer " + number);

        nameField.clear();
        numberField.clear();
    }

    private void startCompetition() {
        System.out.println("Tävlingen har startat!");
    }
}

