package com.example.fabianbolanoscomp228_lab5;

import java.sql.Date;

public class PlayerGame {
    private int playerId;
    private String firstName;
    private String lastName;
    private int gameId;
    private String gameTitle;
    private int score;
    private Date date;

    public PlayerGame(int playerId, String firstName, String lastName, int gameId, String gameTitle, int score, Date date) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.score = score;
        this.date = date;
    }

    // Getters y setters
    public int getPlayerId() { return playerId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getGameId() { return gameId; }
    public String getGameTitle() { return gameTitle; }
    public int getScore() { return score; }
    public Date getDate() { return date; }
}

