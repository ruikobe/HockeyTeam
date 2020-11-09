package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ruizhu
 * @className: Manager
 * @description: Manager Entity
 */
@Entity
@Table
public class Manager {
    @Id
    private String name;
    private int age;

    /**
     * @description: constructor
     * @param: []
     */
    public Manager() {
    }

    /**
     * @description: constructor
     * @param: [name, age]
     */
    public Manager(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
