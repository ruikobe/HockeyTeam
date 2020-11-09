package services;

import models.Skater;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruizhu
 * @className: SkaterService
 * @description: Implement Add/find/update/remove/count methods for skaters
 */
public class SkaterService {
    private static List<Skater> allSkaters = new ArrayList<>();
    private static List<Skater> activeSkaters = new ArrayList<>();

    /**
     * @methodsName: addSkater
     * @description: add a skater to the team, and return the name of the new skater
     * @return: String
     */
    public String addSkater(Skater newSkater){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newSkater);
        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();
        return newSkater.getName();
    }

    /**
     * @methodsName: findSkaterWithMostGoals
     * @description: find the skater with most goads, and return the skater
     * @return: Skater
     */
    public Skater findSkaterWithMostGoals(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e From Skater e where e.totalGoals=(select max(e.totalGoals) from Skater e)");
        List<Skater> foundSkater = query.getResultList();
        return foundSkater.get(0);
    }

    /**
     * @methodsName: findSkaterWithMostGames
     * @description: find the skater with most game played, and return the skater
     * @return: Skater
     */
    public Skater findSkaterWithMostGames(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e From Skater e where e.gamesPlayed=(select max(e.gamesPlayed) from Skater e)");
        List<Skater> foundSkater = query.getResultList();
        return foundSkater.get(0);
    }

    /**
     * @methodsName: updatePlayerStatistics
     * @description: update the statistics of the player with the jersey number "playerNumber"
     * @return: void
     */
    public void updatePlayerStatistics(String playerNumber,String status, String position, int newGoals, int newAssists){

        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Skater foundSkater = entityManager.find(Skater.class, playerNumber);

        if (foundSkater != null){
            int totalGamesPlayed = foundSkater.getGamesPlayed() + 1;
            int totalGoals = foundSkater.getTotalGoals() + newGoals;
            int totalAssists = foundSkater.getTotalAssists() + newAssists;
            double goalsPerGame = totalGoals / totalGamesPlayed;
            double assistsPerGame = totalAssists / totalGamesPlayed;

            foundSkater.setStatus(status);
            foundSkater.setPosition(position);
            foundSkater.setGamesPlayed(totalGamesPlayed);
            foundSkater.setTotalGoals(totalGoals);
            foundSkater.setTotalAssists(totalAssists);
            foundSkater.setGoalsPerGame(goalsPerGame);
            foundSkater.setAssistsPerGame(assistsPerGame);
        }else {
            System.out.println("The player with number " + playerNumber + " does not exist.\n");
        }

        entityManager.getTransaction().commit();
    }

    /**
     * @methodsName: removePlayer
     * @description: remove the player with the jersey number "playerNumber"
     * @return: void
     */
    public void removePlayer(String playerNumber){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Skater foundSkater = entityManager.find(Skater.class, playerNumber);
        if (foundSkater != null){
            entityManager.remove(foundSkater);
        }else {
            System.out.println("The player with number " + playerNumber + " does not exist.\n");
        }
        entityManager.getTransaction().commit();
    }

    /**
     * @methodsName: getAllSkater
     * @description: count the number of all skaters, including "active" and "injured" skaters
     * @return: int
     */
    public static int getAllSkater(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query allSkaterQuery = entityManager.createQuery("SELECT e from Skater e");
        allSkaters = allSkaterQuery.getResultList();

        return allSkaters.size();
    }

    /**
     * @methodsName: getActiveSkater
     * @description: count the number of "active" skaters
     * @return: int
     */
    public static int getActiveSkater(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query activeSkaterQuery = entityManager.createQuery("SELECT e from Skater e WHERE e.status = :givenState");
        activeSkaterQuery.setParameter("givenState","active");
        activeSkaters = activeSkaterQuery.getResultList();

//        for(Skater e:activeSkaters){
//            System.out.println(e.getName());
//        }

        return activeSkaters.size();
    }
}
