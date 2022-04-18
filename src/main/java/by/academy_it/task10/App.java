package by.academy_it.task10;

import by.academy_it.task10.entity.HomeTask;
import by.academy_it.task10.entity.Person;
import by.academy_it.task10.entity.Task;
import by.academy_it.task10.entity.WorkTask;
import by.academy_it.task10.util.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Task task = new Task(null, "Buy coffe", "in bean");

        HomeTask hm = new HomeTask("17.04.2022",
                "19.04.2022",
                new Person("Alexander", "Grigorovich"),
                new Person("Gena", "Vlasik"));
        hm.setName("Math");
        hm.setDescription("drobi");

        WorkTask wt = new WorkTask("1000");
        wt.setName("User manual");
        wt.setDescription("Army topic");

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.persist(hm);
        entityManager.persist(wt);
        entityManager.getTransaction().commit();
        HibernateUtil.close();
    }
}
