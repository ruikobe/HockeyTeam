package models;

import javax.persistence.*;

/**
 Skater Entity
 */
@Entity
@Table
public class Skater extends Player{
    @Id
    private String playerNumber;
    private String name;
    private int age;
    private String status;
    private String position;
    private int gamesPlayed;

    private int totalGoals;
    private int totalAssists;
    private double goalsPerGame;
    private double assistsPerGame;
//    @ManyToMany
//    @JoinTable(name="skater_coach", joinColumns = {@JoinColumn(name="fk_skater")}, inverseJoinColumns = {@JoinColumn(name="fk_coach")})
//    private Set<Coach> coaches = new HashSet<Coach>();

    public Skater() {
    }

    public Skater(String playerNumber, String name, int age, String status, String position, int gamesPlayed, int totalGoals, int totalAssists, double goalsPerGame, double assistsPerGame) {
        this.playerNumber = playerNumber;
        this.name = name;
        this.age = age;
        this.status = status;
        this.position = position;
        this.gamesPlayed = gamesPlayed;
        this.totalGoals = totalGoals;
        this.totalAssists = totalAssists;
        this.goalsPerGame = goalsPerGame;
        this.assistsPerGame = assistsPerGame;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTotalGoals() {
        return totalGoals;
    }

    public void setTotalGoals(int totalGoals) {
        this.totalGoals = totalGoals;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }

    public double getGoalsPerGame() {
        return goalsPerGame;
    }

    public void setGoalsPerGame(double goalsPerGame) {
        this.goalsPerGame = goalsPerGame;
    }

    public double getAssistsPerGame() {
        return assistsPerGame;
    }

    public void setAssistsPerGame(double assistsPerGame) {
        this.assistsPerGame = assistsPerGame;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    @Override
    public String toString() {
        return "Skater{" +
                "playerNumber='" + playerNumber + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                ", position='" + position + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", totalGoals=" + totalGoals +
                ", totalAssists=" + totalAssists +
                ", goalsPerGame=" + goalsPerGame +
                ", assistsPerGame=" + assistsPerGame +
                '}';
    }
}
