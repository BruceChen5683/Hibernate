package ml.battlecall;

import ml.battlecall.model.People;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by chenjianliang on 2018/7/10.
 */
public class HibernateTest {


    public static void main(String[] args) throws  Exception{
        People people = new People();
        people.setUsername("hongyu");
        people.setPassword("123456");
        people.setGender('F');
        people.setBirthday(new java.sql.Date(new java.util.Date().getTime()));
        people.setGraduation(true);
        people.setTelphone(1234567);
        people.setMarryTime(new Timestamp(new java.util.Date().getTime()));

        InputStream inputStream = new FileInputStream("/Users/chenjianliang/IdeaProjects/Hibernate/web/detail.jsp");
        int length = inputStream.available();
        byte[] buffer = new byte[length];
        inputStream.read(buffer);
        people.setFile(buffer);


        Session session = HibernateUtils.openSession();
        Transaction transaction = null;


        try{
            transaction = session.beginTransaction();
            session.save(people);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);
        }

        session = HibernateUtils.openSession();
        Long id = 1L;
        try{
            transaction = session.beginTransaction();
            People people1 = (People) session.get(People.class,id);
            System.out.println("HibernateTest.main "+people1);
            transaction.commit();
        }catch (Exception e){
            System.out.println("HibernateTest.main "+e.toString());
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);
        }







    }
}
