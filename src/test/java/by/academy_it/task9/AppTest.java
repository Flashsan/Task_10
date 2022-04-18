package by.academy_it.task9;

import static org.junit.Assert.assertTrue;

import by.academy_it.task9.entity.Address;
import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void saveTest() {
        EntityManagerFactory ENTITY_MANAGER_FACTORY =
                Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        Address actualAddress = new Address(null, "Parafyanovo", "Maxsim Gorky", "19");
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(actualAddress);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().begin();
        Address addressFromDB = entityManager.find(Address.class, actualAddress.getId());
        Assert.assertEquals(actualAddress, addressFromDB);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void updateNotEqualsTest() {
        EntityManagerFactory ENTITY_MANAGER_FACTORY =
                Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        Address actualAddress = new Address(null, "Parafyanovo", "Maxsim Gorky", "19");
        Address actualAddressBeforeUpdate = new Address(null, "Parafyanovo", "Maxsim Gorky", "19");
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(actualAddress);
            actualAddress.setName("Dokshitsy");
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().begin();
        Address addressFromDB = entityManager.find(Address.class, actualAddress.getId());
        Assert.assertNotEquals(actualAddress, actualAddressBeforeUpdate);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Test
    public void updateEqualsTest() {
        EntityManagerFactory ENTITY_MANAGER_FACTORY =
                Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        Address actualAddress = new Address(null, "Parafyanovo", "Maxsim Gorky", "19");
        Address actualAddressBeforeUpdate = new Address(null, "Dokshitsy", "Maxsim Gorky", "19");
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(actualAddress);
            actualAddress.setName("Dokshitsy");
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().begin();
        Address addressFromDB = entityManager.find(Address.class, actualAddress.getId());
        Assert.assertEquals(actualAddress, addressFromDB);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void deleteTest() {
        EntityManagerFactory ENTITY_MANAGER_FACTORY =
                Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        Address actualAddress = new Address(null, "Parafyanovo", "Maxsim Gorky", "19");

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(actualAddress);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().begin();
        Address addressFromDB = entityManager.find(Address.class, actualAddress.getId());
        Assert.assertEquals(actualAddress, addressFromDB);
        entityManager.remove(addressFromDB);
        Assert.assertNotEquals(actualAddress, null);
        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
