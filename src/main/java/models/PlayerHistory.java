package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class PlayerHistory {
    @Id
    private String playerHistoryId;
    private String playerNumber;
    private Date date;
    private int goals;
    private int assists;
    private int saves;

    public PlayerHistory() {
    }

    public PlayerHistory(String playerHistoryId, String playerNumber, Date date, int goals, int assists, int saves) {
        this.playerHistoryId = playerHistoryId;
        this.playerNumber = playerNumber;
        this.date = date;
        this.goals = goals;
        this.assists = assists;
        this.saves = saves;
    }

    public String getPlayerHistoryId() {
        return playerHistoryId;
    }

    public void setPlayerHistoryId(String playerHistoryId) {
        this.playerHistoryId = playerHistoryId;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
