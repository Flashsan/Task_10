package by.academy_it.task9.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 */
public final class HibernateUtil {

    /**
     *
     */
    private HibernateUtil() {

    }

    /**
     *
     */
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        ENTITY_MANAGER_FACTORY =
                Persistence.createEntityManagerFactory("Task_09");
    }

    /**
     * @return
     * This first method.
     */
    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    /**
     *
     */
    public static void close() {
        ENTITY_MANAGER_FACTORY.close();
    }
}
