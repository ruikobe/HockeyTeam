package models;

import javax.persistence.OneToMany;
import java.util.List;

public class Player {

    private String playerNumber;
    private String name;
    private int age;
    private String status;
    private int gamesPlayed;

    public Player() {
    }

    public Player(String playerNumber, String name, int age, String status, int gamesPlayed) {
        this.playerNumber = playerNumber;
        this.name = name;
        this.age = age;
        this.status = status;
        this.gamesPlayed = gamesPlayed;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerNumber='" + playerNumber + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                '}';
    }
}
