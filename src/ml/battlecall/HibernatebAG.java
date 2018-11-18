package ml.battlecall;

import ml.battlecall.bag.BagItem;
import ml.battlecall.bag.BagQuestion;
import ml.battlecall.list.Item;
import ml.battlecall.list.Question;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class HibernatebAG {
    public static void main(String[] args) {



        Session session = HibernateUtils.openSession();
        Transaction transaction = null;


        try{



            transaction = session.beginTransaction();

            BagQuestion question = new BagQuestion();
            question.setName("q1");

            BagQuestion question1 = new BagQuestion();
            question1.setName("q2");


            BagItem item1 = new BagItem();
            item1.setName("111");

            BagItem item2 = new BagItem();
            item2.setName("h222ow?");

            BagItem item3 = new BagItem();
            item3.setName("wh333o?");

            BagItem item4 = new BagItem();
            item4.setName("wh4444y?");


            question.setItems(new ArrayList<Item>());
            question.getItems().add(item1);
            question.getItems().add(item2);
            question.getItems().add(item3);

//            item1.setQuestion(question);
//            item2.setQuestion(question);
//            item3.setQuestion(question);

            question1.setItems(new ArrayList<Item>());
            question1.getItems().add(item3);
            question1.getItems().add(item4);
//            item3.setQuestion(question1);
//            item4.setQuestion(question1);
//
//            session.save(item1);

            session.save(question);

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
