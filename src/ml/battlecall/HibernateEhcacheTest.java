package ml.battlecall;

import ml.battlecall.ehcache.Student;
import ml.battlecall.hibernate5.EmIDCard;
import ml.battlecall.hibernate5.Employer;
import ml.battlecall.hibernate5.Team;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;

public class HibernateEhcacheTest {
    public static void main(String[] args) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        Session session1 = HibernateUtils.openSession();
        Transaction transaction1 = null;

        try{
            transaction = session.beginTransaction();



            List<Student> list = session.createQuery("from Student order by name").list();
            for (Student employer:list){
                System.out.println(employer.getName());
            }
            transaction.commit();


            System.out.println("HibernateEhcacheTest.main------------------------");


            transaction1 = session1.beginTransaction();
            Student employer1 = session1.get(Student.class,"8a80a89b681bfd2901681bfd2b84003f");
            Student employer2 = session1.get(Student.class,"8a80a89b681bfd2901681bfd2b83003e");


            System.out.println("HibernateEhcacheTest.main ----- "+employer1.getName());
            System.out.println("HibernateEhcacheTest.main ----- "+employer2.getName());
            transaction1.commit();


        }catch (Exception e){
            e.printStackTrace();
            if (null != transaction){
                transaction.rollback();
            }

            if (null != transaction1){
                transaction1.rollback();
            }
        }finally {
            HibernateUtils.close(session);
            HibernateUtils.close(session1);
        }


    }
}
