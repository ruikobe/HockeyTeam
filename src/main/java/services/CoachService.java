package services;

import models.Coach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruizhu
 * @className: CoachService
 * @description: Implement Add/update/remove/count methods for coaches
 */
public class CoachService {
    private static List<Coach> headCoaches = new ArrayList<>();
    private static List<Coach> assistantCoaches = new ArrayList<>();

    /**
     * @methodsName: addCoach
     * @description: add a coach to the team, and return the name of the new coach
     * @return: String
     */
    public String addCoach(Coach newCoach){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newCoach);
        entityManager.getTransaction().commit();
        return newCoach.getName();
    }

    /**
     * @methodsName: updateCoachLevel
     * @description: update the level of the coach with the "name"
     * @return: void
     */
    public void updateCoachLevel(String name, int level){

        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Coach foundCoach = entityManager.find(Coach.class, name);
        if (foundCoach != null){
            foundCoach.setLevel(level);
        }else {
            System.out.println("The coach " + name + "'s level has been updated.\n");
        }
        entityManager.getTransaction().commit();
    }

    /**
     * @methodsName: removeCoach
     * @description: remove the coach with "name"
     * @return: void
     */
    public void removeCoach(String name){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Coach foundCoach = entityManager.find(Coach.class, name);
        if (foundCoach != null){
            entityManager.remove(foundCoach);
        }else {
            System.out.println("The coach " + name + " does not exist.\n");
        }
        entityManager.getTransaction().commit();
    }

    /**
     * @methodsName: getHeadCoachNumber
     * @description: count the number of head coaches
     * @return: int
     */
    public static int getHeadCoachNumber(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query headCoachQuery = entityManager.createQuery("SELECT e from Coach e where e.level = :givenLevel");
        headCoachQuery.setParameter("givenLevel",3);
        headCoaches = headCoachQuery.getResultList();

        return headCoaches.size();
    }

    /**
     * @methodsName: getAssistantCoachNumber
     * @description: count the number of assistant coaches
     * @return: int
     */
    public static int getAssistantCoachNumber(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query assistantCoachQuery = entityManager.createQuery("SELECT e from Coach e where e.level <> :givenLevel");
        assistantCoachQuery.setParameter("givenLevel",3);
        assistantCoaches = assistantCoachQuery.getResultList();

        return assistantCoaches.size();
    }
}
