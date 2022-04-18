package by.academy_it.task9;

import by.academy_it.task9.entity.Address;
import by.academy_it.task9.entity.People;
import by.academy_it.task9.util.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {

        Address ad = new Address(null, "Parafyanovo", "Maxsim Gorky", "19");
        Address ad1 = new Address(null, "Dokshitsy", "Maxsim Gorky", "35");
        People pe = new People(null, "Alexander", "Vasilievich", "Grigorovich");

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(ad);
        em.persist(ad1);
        em.persist(pe);
        Address adRead = em.find(Address.class, 1);
        People peRead = em.find(People.class, 1);
        System.out.println(adRead.toString());
        System.out.println(peRead.toString());
        peRead.setName("Pavel");
        System.out.println(peRead);
        Address adRead1 = em.find(Address.class, 2);
        System.out.println(adRead1.toString());
        em.remove(adRead1);
        em.getTransaction().commit();
        HibernateUtil.close();

    }
}

