package ml.battlecall.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * Created by chenjianliang on 2018/5/29.
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Session openSession(){

        if(sessionFactory == null){
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory.openSession();
    }

    public static void close(Session session){
        if (null != session){
            session.close();
        }
    }
}
