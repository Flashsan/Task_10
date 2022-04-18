package by.academy_it.task10;

import by.academy_it.task10.entity.HomeTask;
import by.academy_it.task10.entity.Person;
import by.academy_it.task10.entity.WorkTask;
import by.academy_it.task10.util.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HomeTask hm = new HomeTask("17.04.2022",
                "19.04.2022",
                new Person("Alexander", "Grigorovich"),
                new Person("Gena", "Vlasik"));
        hm.setName("Math");
        hm.setName("drobi");

        HomeTask hm1 = new HomeTask("15.04.2022",
                "18.04.2022",
                new Person("Alexander", "Grigorovich"),
                new Person("Ilya", "Puticof"));
        hm1.setName("English");
        hm1.setName("Pesent Simple");

        WorkTask wt = new WorkTask("1000");

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(hm);
        entityManager.persist(hm1);
        entityManager.persist(wt);
        entityManager.getTransaction().commit();
        HibernateUtil.close();
    }
}
