package com.example.fabianbolanos_comp228lab5;


import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.*;


import java.lang.reflect.Array;

import static com.example.fabianbolanos_comp228lab5.HelloApplication.initializeDB;

public class HelloController {

    @FXML
    private TextField TextPlayerID, TextFirstName, TextLastName, TextAddress, TextPostalCode, TextProvidence, TextPhoneNumber, TextGameID, TextGameTitle, TextScore;

    @FXML
    private DatePicker Date;

    @FXML
    private ListView<String> GameList;





    private void CreatePlayerAndGame(String player_ID, String game_ID){
        java.sql.Date sqlDate = java.sql.Date.valueOf(Date.getValue());

        try {
            Connection connection = initializeDB();

            String query = "SELECT MAX(PLAYER_GAME_ID) FROM FABIAN_BOLANOS_PLAYERANDGAME";
            try (PreparedStatement queryConsult = connection.prepareStatement(query)) {
                ResultSet resultSet = queryConsult.executeQuery();
                int resultNumber = 0;

                if (resultSet.next()) {
                    resultNumber = resultSet.getInt(1);
                    resultNumber++;
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error to retrieve PLAYER_GAME_ID");
                    alert.setContentText("Unable to retrieve the maximum PLAYER_GAME_ID from the database.");
                    alert.showAndWait();
                    return;
                }

                String insertQuery = "INSERT INTO FABIAN_BOLANOS_PLAYERANDGAME (PLAYER_GAME_ID, GAME_ID, PLAYER_ID, PLAYING_DATE) VALUES (?, ?, ?, ?)";
                try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                    insertStmt.setInt(1, resultNumber);
                    insertStmt.setString(2, game_ID);
                    insertStmt.setString(3, player_ID);
                    insertStmt.setDate(4, sqlDate);
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
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText("An error occurred: " + e.getMessage());
            alert.showAndWait();
        }
    }


    @FXML
    private void onSubmitButtonClick() {

        String PlayerID = TextPlayerID.getText();
        String FirstName = TextFirstName.getText();
        String LastName = TextLastName.getText();
        String Address = TextAddress.getText();
        String PostalCode = TextPostalCode.getText();
        String Province = TextProvidence.getText();
        String PhoneNumber = TextPhoneNumber.getText();
        String GameID = TextGameID.getText();
        String GameTitle = TextGameTitle.getText();

        int playerIdInt = -1;
        int phoneNumberInt = -1;

        try {
            playerIdInt = Integer.parseInt(PlayerID); // Convierte PlayerID a int
            phoneNumberInt = Integer.parseInt(PhoneNumber); // Convierte PhoneNumber a int
        } catch (NumberFormatException e) {
            System.out.println("Error: PlayerID o PhoneNumber no son números válidos.");
        }

        try (Connection connection = initializeDB()) {

            String queryPlayer = "SELECT PLAYER_ID FROM FABIAN_BOLANOS_PLAYER WHERE PLAYER_ID = ?";
            try (PreparedStatement queryConsult = connection.prepareStatement(queryPlayer)) {
                queryConsult.setInt(1, playerIdInt);

                ResultSet resultSetPlayer = queryConsult.executeQuery();

                if (resultSetPlayer.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Player ID already exists");
                    alert.setContentText("A player with this ID already exists in the database.");
                    alert.showAndWait();
                } else {
                    String insertQuery = "INSERT INTO FABIAN_BOLANOS_PLAYER (PLAYER_ID, FIRST_NAME, LAST_NAME, ADDRESS, POSTAL_CODE, PROVINCE, PHONE_NUMBER) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                        insertStmt.setInt(1, playerIdInt);
                        insertStmt.setString(2, FirstName);
                        insertStmt.setString(3, LastName);
                        insertStmt.setString(4, Address);
                        insertStmt.setString(5, PostalCode);
                        insertStmt.setString(6, Province);
                        insertStmt.setInt(7, phoneNumberInt);


                        int rowsInserted = insertStmt.executeUpdate();
                        if (rowsInserted > 0) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("Player added successfully");
                            alert.setContentText("The new player has been successfully added to the database.");
                            alert.showAndWait();
                        }

                        String queryGame = "SELECT GAME_ID FROM FABIAN_BOLANOS_GAME WHERE GAME_ID = ?";
                        try (PreparedStatement queryConsultgame = connection.prepareStatement(queryGame)) {
                            queryConsultgame.setString(1, GameID);
                            ResultSet resultSetgame = queryConsultgame.executeQuery();

                            if (resultSetgame.next()) {
  /*
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Success");
                                alert.setHeaderText("Player added successfully");
                                alert.setContentText("The new player has been successfully added to the database.");
                                alert.showAndWait();

                                String playerIDBD = resultSetPlayer.getString("PLAYER_ID");
                                String gameIDBD = resultSetgame.getString("GAME_ID");

                               // CreatePlayerAndGame(playerIDBD, gameIDBD);
*/
                            }

                            else {
                                String insertQueryGame = "INSERT INTO FABIAN_BOLANOS_GAME (GAME_ID, GAME_TITLE) VALUES (?, ?)";
                                try (PreparedStatement insertStmtGame = connection.prepareStatement(insertQueryGame)) {
                                    insertStmtGame.setString(1, GameID);
                                    insertStmtGame.setString(2, GameTitle);
                                    int rowsInsertedGame = insertStmtGame.executeUpdate();
                                    if (rowsInsertedGame > 0) {
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setTitle("SUCCESSFUL");
                                        alert.setHeaderText("Adding player successfully------------------");
                                        alert.setContentText("The player has been successfully added to the database.-------------------");
                                        alert.showAndWait();
                                    }
                                    String playerIDBD = resultSetPlayer.getString("PLAYER_ID");
                                    //CreatePlayerAndGame(playerIDBD, GameID);
                                }
                            }
                        }
                    }
                }
            }

            /*TextPlayerID.setText("");
            TextFirstName.setText("");
            TextLastName.setText("");
            TextAddress.setText("");
            TextPostalCode.setText("");
            TextProvidence.setText("");
            TextPhoneNumber.setText("");
            TextGameID.setText("");
            TextGameTitle.setText("");
            Date.setValue(null);*/


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText("General Error");
            alert.setContentText("An error occurred: " + e.getMessage());
            alert.showAndWait();
        }
    }


}