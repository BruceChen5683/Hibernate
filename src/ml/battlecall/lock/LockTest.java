package ml.battlecall.lock;

import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LockTest {
    public static void main(String[] args) {

        Transaction transaction = null;
        Transaction transaction1 = null;
        Transaction transaction2 = null;
        Session session1 = HibernateUtils.openSession();
        Session session2 = HibernateUtils.openSession();


        try {
//            transaction = session1.beginTransaction();

//            Student student = new Student();
//            student.setName("test");
//            student.setId("1");
//
//            session.save(student);

            Student student1 = (Student) session1.createQuery("from  Student s where s.name = :name").setString("name","test").uniqueResult();

            Student student2 = (Student) session2.createQuery("from  Student s where s.name = :name").setString("name","test").uniqueResult();

            System.out.println("LockTest.main "+student1.getVersion());
            System.out.println("LockTest.main "+student2.getVersion());



            transaction1 = session1.beginTransaction();
            student1.setName("test1");
            transaction1.commit();

            System.out.println("LockTest.main "+student1.getVersion());
            System.out.println("LockTest.main "+student2.getVersion());


            transaction2 = session2.beginTransaction();
            student2.setName("test2");
            transaction2.commit();

            System.out.println("LockTest.main "+student1.getVersion());
            System.out.println("LockTest.main "+student2.getVersion());

//            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (null != transaction){
                transaction.rollback();
            }
        }finally {
//            HibernateUtils.close(session);
            HibernateUtils.close(session1);
            HibernateUtils.close(session2);
        }


    }
}
