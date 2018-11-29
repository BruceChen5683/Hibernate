package ml.battlecall;

import ml.battlecall.inherit.Person;
import ml.battlecall.inherit.StudentEP;
import ml.battlecall.inherit.Teacher;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;

public class HibernateInheritTest {
    public static void main(String[] args) {


        Session session = HibernateUtils.openSession();
        Transaction transaction = null;


        try{

            transaction = session.beginTransaction();

//            Teacher teacher = new Teacher();
//            teacher.setName("hy");
//            teacher.setId("1");
//            teacher.setSalary("1000");
//
//
//            StudentEP studentEP = new StudentEP();
//            studentEP.setName("none");
//            studentEP.setId("22");
//            studentEP.setCardId("0001");
//
//
//            session.save(teacher);
//            session.save(studentEP);

//            Query query = session.createQuery("from java.lang.Object");

            Query query = session.createQuery("from ml.battlecall.inherit.Person");
            Iterator iterator = query.iterate();
            while (iterator.hasNext()){
                Person p  = (Person) iterator.next();

                System.out.println("HibernateInheritTest.main"+p.getName());
            }

            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();

            if (null != transaction){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);
        }
    }
}
