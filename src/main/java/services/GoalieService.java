package services;

import models.Goalie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruizhu
 * @className: GoalieService
 * @description: Implement Add/find/update/remove/count methods for goalies
 */
public class GoalieService {
    private static List<Goalie> allGoalies = new ArrayList<>();
    private static List<Goalie> activeGoalies = new ArrayList<>();

    /**
     * @methodsName: addGoalie
     * @description: add a goalie to the team, and return the name of the new goalie
     * @return: String
     */
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

    /**
     * @methodsName: findGoalieWithFewestSaves
     * @description: find the goalie with fewest saves, and return the goalie
     * @return: Goalie
     */
    public Goalie findGoalieWithFewestSaves(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e From Goalie e where e.totalSaves=(select min(e.totalSaves) from Goalie e)");
        List<Goalie> foundGoalie = query.getResultList();
        return foundGoalie.get(0);
    }

    /**
     * @methodsName: findGoalieWithMostGames
     * @description: find the goalie with most game played, and return the goalie
     * @return: Goalie
     */
    public Goalie findGoalieWithMostGames(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e From Goalie e where e.gamesPlayed=(select max(e.gamesPlayed) from Goalie e)");
        List<Goalie> foundGoalie = query.getResultList();
        return foundGoalie.get(0);
    }

    /**
     * @methodsName: updatePlayerStatistics
     * @description: update the statistics of the player with the jersey number "playerNumber"
     * @return: void
     */
    public void updatePlayerStatistics(String playerNumber,String status, int newSaves){

        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Goalie foundGoalie = entityManager.find(Goalie.class, playerNumber);

        if (foundGoalie != null){
            int totalGamesPlayed = foundGoalie.getGamesPlayed() + 1;
            int totalSaves = foundGoalie.getTotalSaves() + newSaves;
            double savesPerGame = totalSaves / totalGamesPlayed;

            foundGoalie.setStatus(status);
            foundGoalie.setGamesPlayed(totalGamesPlayed);
            foundGoalie.setTotalSaves(totalSaves);
            foundGoalie.setSavesPerGame(savesPerGame);
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

        Goalie foundGoalie = entityManager.find(Goalie.class, playerNumber);
        if (foundGoalie != null){
            entityManager.remove(foundGoalie);
        }else {
            System.out.println("The player with number " + playerNumber + " does not exist.\n");
        }
        entityManager.getTransaction().commit();
    }

    /**
     * @methodsName: getAllGoalieNumber
     * @description: count the number of all goalies, including "active" and "injured" goalies
     * @return: int
     */
    public static int getAllGoalieNumber(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query allGoalieQuery = entityManager.createQuery("SELECT e from Goalie e");
        allGoalies = allGoalieQuery.getResultList();

        return allGoalies.size();
    }

    /**
     * @methodsName: getActiveGoalieNumber
     * @description: count the number of "active" goalies
     * @return: int
     */
    public static int getActiveGoalieNumber(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query activeGoalieQuery = entityManager.createQuery("SELECT e from Goalie e WHERE e.status = :givenState");
        activeGoalieQuery.setParameter("givenState","active");
        activeGoalies = activeGoalieQuery.getResultList();

        return activeGoalies.size();
    }
}
