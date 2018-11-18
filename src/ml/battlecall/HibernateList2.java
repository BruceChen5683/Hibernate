package ml.battlecall;

import ml.battlecall.list.Item;
import ml.battlecall.list.Question;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class HibernateList2 {
    public static void main(String[] args) {


        System.out.println("HibernateList2.main");

        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        System.out.println("HibernateList2.main 2");

        try{

            System.out.println("HibernateList2.main  3");


            transaction = session.beginTransaction();
            System.out.println("HibernateList2.main 4");

            Question question = new Question();
            question.setName("q1");
            System.out.println("HibernateList2.main 5");

            Question question1 = new Question();
            question1.setName("q2");


            Item item1 = new Item();
            item1.setName("111");
            System.out.println("HibernateList2.main 6");

            Item item2 = new Item();
            item2.setName("h222ow?");

            Item item3 = new Item();
            item3.setName("wh333o?");

            Item item4 = new Item();
            item4.setName("wh4444y?");


            question.setItems(new ArrayList<Item>());
            question.getItems().add(item1);
            System.out.println("HibernateList2.main  77");
            question.getItems().add(item2);

            question1.setItems(new ArrayList<Item>());
            question1.getItems().add(item3);
            question1.getItems().add(item4);
//
//            session.save(item1);

            session.save(question);
            System.out.println("HibernateList2.main 7");

            session.save(question1);

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
