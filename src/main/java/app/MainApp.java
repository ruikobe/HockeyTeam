package app;

import models.*;
import services.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {
    public static void main(String[] args) {

        TeamService team = new TeamService();
        team.teamValid();

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /**
         * Skater services
         */
        SkaterService skaterService = new SkaterService();
        /**
         * Add a new player (skater)
         */
        Skater newPlayer = new Skater("3", "James", 15, "injured", "wing",0,0,0,0.0,0.0);
        //System.out.println("The new player "+ skaterService.addSkater(newPlayer) + " has been added to the team as a skater.\n");

        /**
         * Find a player with the most goals
         */
        System.out.println("The skater with the most goals for the entire season is " + skaterService.findSkaterWithMostGoals().getName()+ ".\n" + "His total goals are " + skaterService.findSkaterWithMostGoals().getTotalGoals() + ".\n");

        /**
         * Update a Player's Statistics after one game
         */
        //skaterService.updatePlayerStatistics("2","active","wing",20,10);

        /**
         * Remove a player
         */
        //skaterService.removePlayer("3");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /**
         * Goalie services
         */
        GoalieService goalieService = new GoalieService();
        Goalie newPlayer2 = new Goalie("5","Hello",15,"active",0,0,0.0);
        //System.out.println("The new player "+ goalieService.addGoalie(newPlayer2) + " has been added to the team as a goalie.\n");
        goalieService.updatePlayerStatistics("5","injured",1);
        System.out.println("The goalie with the fewest saves for the entire season is " + goalieService.findGoalieWithFewestSaves().getName()+ ".\n" + "His total number of saves is " + goalieService.findGoalieWithFewestSaves().getTotalSaves() + ".\n");


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /**
         * Coach services
         */
        CoachService coachService = new CoachService();
        coachService.updateCoachLevel("Bob",1);

        PlayerService playerService = new PlayerService();
        System.out.println("MVP: " + playerService.findPlayerWithMostGames().getName());


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /**
         * Initialize Database
         */
//        EntityManagerFactory factory  = Persistence.createEntityManagerFactory("default");
//        EntityManager manager = factory.createEntityManager();
//        manager.getTransaction().begin();
//        Manager manager1 = new Manager("Boss", 61);
//        manager.persist(manager1);
//        Coach headCoach = new Coach("Alice", 40, 3);
//        manager.persist(headCoach);
//        Coach coach1 = new Coach("Bob", 33, 2);
//        manager.persist(coach1);
//        Goalie player1 = new Goalie("1", "Mike", 15, "active",0, 0,0.0);
//        manager.persist(player1);
//        Skater player2 = new Skater("2", "Miller", 15, "injured", "wing",0,0,0,0.0,0.0);
//        manager.persist(player2);
//        manager.getTransaction().commit();
//        manager.close();
//        factory.close();

    }
}