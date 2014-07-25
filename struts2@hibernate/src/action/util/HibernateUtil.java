package action.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Administrator on 14-7-25.
 */
public class HibernateUtil {
      private static Configuration configuration = new Configuration().configure();
      private static ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
      private static SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
