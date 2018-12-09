package ml.battlecall;

import ml.battlecall.combineKey.MyStudent;
import ml.battlecall.hibernate5.EmIDCard;
import ml.battlecall.hibernate5.Employer;
import ml.battlecall.hibernate5.Team;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;

public class HiberateTest55 {
    public static void main(String[] args) {

//        MyStudent myStudent = new MyStudent();
//        myStudent.setAge(1);
//        myStudent.setCardId("123456");
//        myStudent.setName("cjl");
//
//
//        Session session = HibernateUtils.openSession();
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//
//            session.save(myStudent);
//
//            transaction.commit();
//        }catch (Exception e){
//            e.printStackTrace();
//            if (null != transaction){
//                transaction.rollback();
//            }
//        }finally {
//            HibernateUtils.close(session);
//        }


        MyStudent  studentPrimaryKey = new MyStudent();
        studentPrimaryKey.setCardId("123456");
        studentPrimaryKey.setName("cjl");


        Session session = HibernateUtils.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();//对应底层　Ｃｏｎｎｅｃｔｉｏｎ setAutoCommit(false)

            MyStudent myStudent = session.get(MyStudent.class,studentPrimaryKey);
            System.out.println("HiberateTest55.main "+myStudent.getAge());
            System.out.println("HiberateTest55.main "+studentPrimaryKey.getAge());

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
