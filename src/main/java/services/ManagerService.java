package services;

import models.Manager;
import models.Skater;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ManagerService {
    private static List<Manager> managers = new ArrayList<>();

    public String addManager(Manager newManager){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newManager);
        entityManager.getTransaction().commit();
        return newManager.getName();
    }

    public void removeManager(String name){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Manager foundManager = entityManager.find(Manager.class, name);
        if (foundManager != null){
            entityManager.remove(foundManager);
        }else {
            System.out.println("The manager " + name + " does not exist.\n");
        }
        entityManager.getTransaction().commit();
    }

    public static int getManagerNubmer(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT e from Manager e");
        managers = query.getResultList();

        return managers.size();
    }
}
