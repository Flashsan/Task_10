package by.academy_it.task9.util;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.module.Configuration;

public class HibernateUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Task_09");
    }

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void close() {
        ENTITY_MANAGER_FACTORY.close();
    }

//    private HibernateUtil() {
//        try {
//            Configuration configuration = new Configuration().configure();
//            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                    .applySettings(configuration.getProperties());
//            sessionFactory = configuration.buildSessionFactory(builder.build());
//        }catch (Trowable e) {
//            log.error("Initial SessionFactory creation failed. " + e);
//            throw new ExceptionInitializerError(e);
//        }
//    }

//    public static Session getSession() {
//        return sessionFactory.openSession();
//    }
}
