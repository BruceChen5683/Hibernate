package ml.battlecall;

import ml.battlecall.info.IDCard;
import ml.battlecall.info.Student;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by chenjianliang on 2018/11/5.
 */
public class HibernateTest4 {
    public static void main(String[] args) {

        Student student = new Student();
        student.setName("test");

        IDCard idCard = new IDCard();
        idCard.setNumber("123");
        student.setIdCard(idCard);
        idCard.setStudent(student);


        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();

        }catch (Exception e){
            if (null != transaction){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);
        }


        /**
         * fetch 属性 select or join
         *
         *
         *              ******select:******
         *
         * Hibernate: select student0_.ID as ID1_1_0_, student0_.NAME as NAME2_1_0_ from student student0_ where student0_.ID=?
         * Hibernate: select idcard0_.ID as ID1_0_0_, idcard0_.NUMBER as NUMBER2_0_0_, student1_.ID as ID1_1_1_, student1_.NAME as NAME2_1_1_ from idcard idcard0_ left outer join student student1_ on idcard0_.ID=student1_.ID where idcard0_.ID=?
         * HibernateTest4.main 123
         *
         *
         *              ******join:*****
         * Hibernate: select student0_.ID as ID1_1_0_, student0_.NAME as NAME2_1_0_, idcard1_.ID as ID1_0_1_, idcard1_.NUMBER as NUMBER2_0_1_ from student student0_ left outer join idcard idcard1_ on student0_.ID=idcard1_.ID where student0_.ID=?
         * HibernateTest4.main 123
         * */
        /*Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Student student = session.get(Student.class,"402881ed66e1344d0166e1344fdb0000");
            System.out.println("HibernateTest4.main "+ student.getIdCard().getNumber());
            transaction.commit();

        }catch (Exception e){
            if (null != transaction){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);
        }/


        /**
         * 延迟加载
         * */

        /*Session session = HibernateUtils.openSession();
        Transaction transaction = null;
        Student student = null;

        try{
            transaction = session.beginTransaction();
            student = session.get(Student.class,"402881ed66e1344d0166e1344fdb0000");
            student.setName("hy");
            transaction.commit();

        }catch (Exception e){
            if (null != transaction){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);

            System.out.println("HibernateTest4.main "+ student.getName());

        }*/

        /**
         * delete
         * */
        /*Session session = HibernateUtils.openSession();
        Transaction transaction = null;
        Student student = null;

        try{
            transaction = session.beginTransaction();
            student = session.get(Student.class,"402881ed66e1344d0166e1344fdb0000");
            session.delete(student);
            transaction.commit();

        }catch (Exception e){
            if (null != transaction){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);

            System.out.println("HibernateTest4.main "+ student.getName());

        }*/
    }
}
