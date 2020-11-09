package services;

import models.Manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruizhu
 * @className: ManagerService
 * @description: Implement Add/remove/count methods for managers
 */
public class ManagerService {
    private static List<Manager> managers = new ArrayList<>();

    /**
     * @methodsName: addManager
     * @description: add a manager to the team, and return the name of the new manager
     * @return: String
     */
    public String addManager(Manager newManager){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newManager);
        entityManager.getTransaction().commit();
        return newManager.getName();
    }

    /**
     * @methodsName: removeManager
     * @description: remove the manager from the team
     * @return: void
     */
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

    /**
     * @methodsName: getManagerNubmer
     * @description: count the number of managers in this team
     * @return: int
     */
    public static int getManagerNubmer(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT e from Manager e");
        managers = query.getResultList();

        return managers.size();
    }
}
