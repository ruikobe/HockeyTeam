package models;

import javax.persistence.*;

@Entity
@Table
public class PlayerHistory {
    @Id
    private int playerHistoryId;
    private String playerNumber;
    private String date;
    private int goals;
    private int assists;
    private int saves;

    public PlayerHistory() {
    }

    public PlayerHistory(int playerHistoryId, String playerNumber, String date, int goals, int assists, int saves) {
        this.playerHistoryId= playerHistoryId;
        this.playerNumber = playerNumber;
        this.date = date;
        this.goals = goals;
        this.assists = assists;
        this.saves = saves;
    }

    public int getPlayerHistoryId() {
        return playerHistoryId;
    }

    public void setPlayerHistoryId(int playerHistoryId) {
        this.playerHistoryId = playerHistoryId;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }
}
