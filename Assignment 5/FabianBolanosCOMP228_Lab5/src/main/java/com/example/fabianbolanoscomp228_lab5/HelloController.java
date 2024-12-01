package com.example.fabianbolanoscomp228_lab5;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.*;
import java.sql.*;
import static com.example.fabianbolanoscomp228_lab5.HelloApplication.initializeDB;


public class HelloController {

    @FXML
    private TextField TextPlayerID, TextFirstName, TextLastName, TextAddress, TextPostalCode, TextProvidence, TextPhoneNumber, TextGameID, TextGameTitle, TextScore;

    @FXML
    private DatePicker Date;

    @FXML
    private TableView<PlayerGame> playerGameTable;

    @FXML
    private TableColumn<PlayerGame, Integer> playerIDColumn, gameIDColumn, scoreColumn;

    @FXML
    private TableColumn<PlayerGame, String> firstNameColumn, lastNameColumn, gameTitleColumn;

    @FXML
    private TableColumn<PlayerGame, Date> dateColumn;

    @FXML
    public void initialize() {
        playerIDColumn.setCellValueFactory(new PropertyValueFactory<>("playerId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        gameIDColumn.setCellValueFactory(new PropertyValueFactory<>("gameId"));
        gameTitleColumn.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void CreatePlayerAndGame(int player_ID, int game_ID){
        java.sql.Date sqlDate = java.sql.Date.valueOf(Date.getValue());
        String Score = TextScore.getText();

        int ScoreInt = -1;

        try {
            ScoreInt = Integer.parseInt(Score); // Convierte PlayerID a int
        } catch (NumberFormatException e) {
            System.out.println("Error: PlayerID o PhoneNumber no son números válidos.");
        }

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
                    alert.setHeaderText("Player ID already exists");
                    alert.setContentText("A player with this ID already exists in the database.");
                    alert.showAndWait();
                    return;
                }

                String insertQuery = "INSERT INTO FABIAN_BOLANOS_PLAYERANDGAME (PLAYER_GAME_ID, GAME_ID, PLAYER_ID, PLAYING_DATE, SCORE) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                    insertStmt.setInt(1, resultNumber);
                    insertStmt.setInt(2, game_ID);
                    insertStmt.setInt(3, player_ID);
                    insertStmt.setDate(4, sqlDate);
                    insertStmt.setInt(5,ScoreInt);
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
            TextPlayerID.setText("");
            TextFirstName.setText("");
            TextLastName.setText("");
            TextAddress.setText("");
            TextPostalCode.setText("");
            TextProvidence.setText("");
            TextPhoneNumber.setText("");
            TextGameID.setText("");
            TextGameTitle.setText("");
            TextScore.setText("");
            Date.setValue(null);
            playerGameTable.setItems(FXCollections.observableArrayList());



        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText("An error occurred: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void OnConsultButtonClick(){
        String PlayerID = TextPlayerID.getText();

        if(TextPlayerID.getText()==""){

            showAlert("Empty fields","The Player ID is mandatory");

        } else{
            int playerIdInt = -1;

            try {
                playerIdInt = Integer.parseInt(PlayerID);
            } catch (NumberFormatException e) {
                System.out.println("Error: PlayerID o PhoneNumber no son números válidos.");
            }

            ObservableList<PlayerGame> playerGameList = FXCollections.observableArrayList();

            try (Connection connection = initializeDB()) {

                String queryPlayer = "SELECT * FROM FABIAN_BOLANOS_PLAYER WHERE PLAYER_ID = ?";
                try (PreparedStatement queryConsult = connection.prepareStatement(queryPlayer)) {
                    queryConsult.setInt(1, playerIdInt);

                    ResultSet resultSetPlayer = queryConsult.executeQuery();

                    if (resultSetPlayer.next()) {
                        TextPlayerID.setText(String.valueOf(resultSetPlayer.getInt("PLAYER_ID")));
                        TextFirstName.setText(resultSetPlayer.getString("FIRST_NAME"));
                        TextLastName.setText(resultSetPlayer.getString("LAST_NAME"));
                        TextAddress.setText(resultSetPlayer.getString("ADDRESS"));
                        TextPostalCode.setText(resultSetPlayer.getString("POSTAL_CODE"));
                        TextProvidence.setText(resultSetPlayer.getString("PROVINCE"));
                        TextPhoneNumber.setText(String.valueOf(resultSetPlayer.getInt("PHONE_NUMBER")));
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Player ID does not exists");
                        alert.setContentText("A player with this ID does not exist in the database.");
                        alert.showAndWait();

                    }
                }


                // Consulta de los detalles del juego
                String gameQuery = """
                SELECT PLAYER_ID, FIRST_NAME, LAST_NAME, GAME_ID, GAME_TITLE, PLAYING_DATE, SCORE
                FROM FABIAN_BOLANOS_PLAYER JOIN FABIAN_BOLANOS_PLAYERANDGAME USING (PLAYER_ID)
                JOIN FABIAN_BOLANOS_GAME USING (GAME_ID)
                WHERE PLAYER_ID = ?""";
                try (PreparedStatement gameStmt = connection.prepareStatement(gameQuery)) {
                    gameStmt.setInt(1, playerIdInt);
                    ResultSet gameResult = gameStmt.executeQuery();

                    while (gameResult.next()) {
                        PlayerGame playerGame = new PlayerGame(
                                gameResult.getInt("PLAYER_ID"),
                                gameResult.getString("FIRST_NAME"),
                                gameResult.getString("LAST_NAME"),
                                gameResult.getInt("GAME_ID"),
                                gameResult.getString("GAME_TITLE"),
                                gameResult.getInt("SCORE"),
                                gameResult.getDate("PLAYING_DATE")
                        );
                        playerGameList.add(playerGame);
                    }
                }
                playerGameTable.setItems(playerGameList);



            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database Error");
                alert.setHeaderText("General Error");
                alert.setContentText("An error occurred: " + e.getMessage());
                alert.showAndWait();
            }
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

        if(TextPlayerID.getText()=="" || TextGameID.getText()==""){

            showAlert("Empty fields","The fields with * are mandatory");

        } else{
            int playerIdInt = -1;
            int phoneNumberInt = -1;
            int GameIDInt = -1;

            try {
                playerIdInt = Integer.parseInt(PlayerID); // Convierte PlayerID a int
                phoneNumberInt = Integer.parseInt(PhoneNumber); // Convierte PhoneNumber a int
                GameIDInt = Integer.parseInt(GameID);
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
                        OnConsultButtonClick();
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
                            insertStmt.executeUpdate();
                        }
                    }
                    String queryGame = "SELECT GAME_ID FROM FABIAN_BOLANOS_GAME WHERE GAME_ID = ?";
                    try (PreparedStatement queryConsultgame = connection.prepareStatement(queryGame)) {
                        queryConsultgame.setInt(1, GameIDInt);
                        ResultSet resultSetgame = queryConsultgame.executeQuery();
                        if (!resultSetgame.next()) {
                            String insertQueryGame = "INSERT INTO FABIAN_BOLANOS_GAME (GAME_ID, GAME_TITLE) VALUES (?, ?)";
                            try (PreparedStatement insertStmtGame = connection.prepareStatement(insertQueryGame)) {
                                insertStmtGame.setString(1, GameID);
                                insertStmtGame.setString(2, GameTitle);
                                insertStmtGame.executeUpdate();
                            }
                        }
                    }
                    CreatePlayerAndGame(playerIdInt, GameIDInt);
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database Error");
                alert.setHeaderText("General Error");
                alert.setContentText("An error occurred: " + e.getMessage());
                alert.showAndWait();
            }
        }

    }

    @FXML
    private void OnEditButtonClick(){
        String PlayerID = TextPlayerID.getText();
        String FirstName = TextFirstName.getText();
        String LastName = TextLastName.getText();
        String Address = TextAddress.getText();
        String PostalCode = TextPostalCode.getText();
        String Province = TextProvidence.getText();
        String PhoneNumber = TextPhoneNumber.getText();

        int playerIdInt = -1;
        int phoneNumberInt = -1;

        if(TextPlayerID.getText()==""){

            showAlert("Empty fields","The Player ID is mandatory");

        } else{
            try {
                playerIdInt = Integer.parseInt(PlayerID);
                phoneNumberInt = Integer.parseInt(PhoneNumber);
            } catch (NumberFormatException e) {
                System.out.println("Error: PlayerID o PhoneNumber no son números válidos.");
            }

            try (Connection connection = initializeDB()) {

                String queryPlayer = "SELECT PLAYER_ID FROM FABIAN_BOLANOS_PLAYER WHERE PLAYER_ID = ?";
                try (PreparedStatement queryConsult = connection.prepareStatement(queryPlayer)) {
                    queryConsult.setInt(1, playerIdInt);

                    ResultSet resultSetPlayer = queryConsult.executeQuery();

                    if (resultSetPlayer.next()) {
                        String updateQuery = "UPDATE FABIAN_BOLANOS_PLAYER SET FIRST_NAME = ?, LAST_NAME = ?, ADDRESS = ?, POSTAL_CODE = ?, PROVINCE = ?, PHONE_NUMBER = ? WHERE PLAYER_ID = ?";
                        try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                            updateStmt.setString(1, FirstName);
                            updateStmt.setString(2, LastName);
                            updateStmt.setString(3, Address);
                            updateStmt.setString(4, PostalCode);
                            updateStmt.setString(5, Province);
                            updateStmt.setInt(6, phoneNumberInt);
                            updateStmt.setInt(7, playerIdInt);
                            updateStmt.executeUpdate();

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("Player updated successfully");
                            alert.setContentText("The  player has been successfully undated to the database.");
                            alert.showAndWait();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Player ID does not exists");
                        alert.setContentText("A player with this ID does not exist in the database.");
                        alert.showAndWait();
                    }
                }
                TextPlayerID.setText("");
                TextFirstName.setText("");
                TextLastName.setText("");
                TextAddress.setText("");
                TextPostalCode.setText("");
                TextProvidence.setText("");
                TextPhoneNumber.setText("");
                playerGameTable.setItems(FXCollections.observableArrayList());

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database Error");
                alert.setHeaderText("General Error");
                alert.setContentText("An error occurred: " + e.getMessage());
                alert.showAndWait();
            }
        }
    }
}