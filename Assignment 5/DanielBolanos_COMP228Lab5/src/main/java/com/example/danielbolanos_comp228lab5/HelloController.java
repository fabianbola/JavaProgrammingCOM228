package com.example.danielbolanos_comp228lab5;


import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.*;


import java.lang.reflect.Array;

import static com.example.danielbolanos_comp228lab5.HelloApplication.initializeDB;

public class HelloController {

    @FXML
    private TextField TextPlayerID, TextFirstName, TextLastName, TextAddress, TextPostalCode, TextProvidence, TextPhoneNumber, TextGameID, TextGameTitle, TextScore;

    @FXML
    private ListView<String> GameList;


    @FXML
    private void onSubmitButtonClick() {
        String PlayerID = TextPlayerID.getText();
        String FirstName = TextFirstName.getText();
        String LastName = TextLastName.getText();
        String Address = TextAddress.getText();
        String PostalCode = TextPostalCode.getText();
        String Providence = TextProvidence.getText();
        String PhoneNumber = TextPhoneNumber.getText();
        String GameID = TextGameID.getText();
        String GameTitle = TextGameTitle.getText();
        String Score = TextScore.getText();

        try (Connection connection = initializeDB()) {

            String query = "SELECT PLAYER_ID FROM FABIAN_BOLANOS_PLAYER WHERE PLAYER_ID = ?";
            try (PreparedStatement queryConsult = connection.prepareStatement(query)) {
                queryConsult.setString(1, PlayerID);

                ResultSet resultSet = queryConsult.executeQuery();

                if (resultSet.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Player ID already exists");
                    alert.setContentText("A player with this ID already exists in the database.");
                    alert.showAndWait();
                } else {
                    String insertQuery = "INSERT INTO FABIAN_BOLANOS_PLAYER (PLAYER_ID, FIRST_NAME, LAST_NAME, ADDRESS, POSTAL_CODE, PROVIDENCE, PHONE_NUMBER, GAME_ID, GAME_TITLE, SCORE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                        insertStmt.setString(1, PlayerID);
                        insertStmt.setString(2, FirstName);
                        insertStmt.setString(3, LastName);
                        insertStmt.setString(4, Address);
                        insertStmt.setString(5, PostalCode);
                        insertStmt.setString(6, Providence);
                        insertStmt.setString(7, PhoneNumber);
                        insertStmt.setString(8, GameID);
                        insertStmt.setString(9, GameTitle);
                        insertStmt.setString(10, Score);

                        int rowsInserted = insertStmt.executeUpdate();
                        if (rowsInserted > 0) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("Player added successfully");
                            alert.setContentText("The new player has been successfully added to the database.");
                            alert.showAndWait();
                        }
                    }
                }
            }

        } catch (Exception e) {
            // Manejo general de excepciones
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText("General Error");
            alert.setContentText("An error occurred: " + e.getMessage());
            alert.showAndWait();
        }
    }

}