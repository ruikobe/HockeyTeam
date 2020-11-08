package services;

import models.Coach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CoachService {
    private static List<Coach> headCoaches;
    private static List<Coach> assistantCoaches;

    public String addCoach(Coach newCoach){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newCoach);
        entityManager.getTransaction().commit();
        return newCoach.getName();
    }

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

    public static int getHeadCoachNumber(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query headCoachQuery = entityManager.createQuery("SELECT e from Coach e where e.level = :givenLevel");
        headCoachQuery.setParameter("givenLevel",3);
        headCoaches = headCoachQuery.getResultList();

        return headCoaches.size();

    }

    public static int getAssistantCoachNumber(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query assistantCoachQuery = entityManager.createQuery("SELECT e from Coach e where e.level <> :givenLevel");
        assistantCoachQuery.setParameter("givenLevel",3);
        assistantCoaches = assistantCoachQuery.getResultList();

        return assistantCoaches.size();
    }
}
