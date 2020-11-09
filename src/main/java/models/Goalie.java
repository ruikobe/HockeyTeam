package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruizhu
 * @className: Gaolie
 * @description: Goalie Entity, subclass of Player
 */
@Entity
@Table
public class Goalie extends Player{

    @Id
    private String playerNumber;
    private String name;
    private int age;
    private String status;
    private int gamesPlayed;

    private int totalSaves;
    private double savesPerGame;

    /**
     * @description: One to Many Relationship between tables Goalie and PlayerHistory
     */
    @OneToMany(targetEntity = PlayerHistory.class)
    private List<PlayerHistory> playerHistoryList = new ArrayList<>();

    /**
     * @description: constructor
     * @param: []
     */
    public Goalie() {
    }

    /**
     * @description: constructor
     * @param: [playerNumber, name, age, status, gamesPlayed, totalSaves, savesPerGame]
     */
    public Goalie(String playerNumber, String name, int age, String status, int gamesPlayed, int totalSaves, double savesPerGame) {
        this.playerNumber = playerNumber;
        this.name = name;
        this.age = age;
        this.status = status;
        this.gamesPlayed = gamesPlayed;
        this.totalSaves = totalSaves;
        this.savesPerGame = savesPerGame;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalSaves() {
        return totalSaves;
    }

    public void setTotalSaves(int totalSaves) {
        this.totalSaves = totalSaves;
    }

    public double getSavesPerGame() {
        return savesPerGame;
    }

    public void setSavesPerGame(double savesPerGame) {
        this.savesPerGame = savesPerGame;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    @Override
    public String toString() {
        return "Goalie{" +
                "playerNumber='" + playerNumber + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", totalSaves=" + totalSaves +
                ", savesPerGame=" + savesPerGame +
                '}';
    }
}
