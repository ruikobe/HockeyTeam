package services;

import models.Goalie;
import models.Skater;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class GoalieService {
    private static List<Goalie> allGoalies;
    private static List<Goalie> activeGoalies;

    public String addGoalie(Goalie newGoalie){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newGoalie);
        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();
        return newGoalie.getName();
    }

    public Goalie findPlayer(String playerNumber){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Goalie foundGoalie = entityManager.find(Goalie.class, playerNumber);
        return foundGoalie;
    }

    public void updatePlayerStatistics(String playerNumber,String status, int newSaves){

        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Goalie foundGoalie = entityManager.find(Goalie.class, playerNumber);
        int totalGamesPlayed = foundGoalie.getGamesPlayed() + 1;
        int totalSaves = foundGoalie.getTotalSaves() + newSaves;
        double savesPerGame = totalSaves / totalGamesPlayed;

        if (foundGoalie != null){
            foundGoalie.setStatus(status);
            foundGoalie.setGamesPlayed(totalGamesPlayed);
            foundGoalie.setTotalSaves(totalSaves);
            foundGoalie.setSavesPerGame(savesPerGame);
        }else {
            System.out.println("The player with number " + playerNumber + " does not exist.\n");
        }

        entityManager.getTransaction().commit();
    }

    public void removePlayer(String playerNumber){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Goalie foundGoalie = entityManager.find(Goalie.class, playerNumber);
        if (foundGoalie != null){
            entityManager.remove(foundGoalie);
        }else {
            System.out.println("The player with number " + playerNumber + " does not exist.\n");
        }
        entityManager.getTransaction().commit();
    }

    public static int getAllGoalieNumber(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query allGoalieQuery = entityManager.createQuery("SELECT e from Goalie e");
        allGoalies = allGoalieQuery.getResultList();

        return allGoalies.size();
    }

    public static int getActiveGoalieNumber(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query activeGoalieQuery = entityManager.createQuery("SELECT e from Goalie e WHERE e.status = :givenState");
        activeGoalieQuery.setParameter("givenState","active");
        activeGoalies = activeGoalieQuery.getResultList();

        return activeGoalies.size();
    }
}
