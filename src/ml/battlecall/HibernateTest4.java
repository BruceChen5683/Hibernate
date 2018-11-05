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
    }
}
