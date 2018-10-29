package ml.battlecall;

import ml.battlecall.model.People;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.sql.QuerySelect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chenjianliang on 2018/7/10.
 */
public class HibernateTest {


    public static void main(String[] args) throws  Exception{
//        People people = new People();
//        people.setUsername("cjl");
//        people.setPassword("123456");
//        people.setGender('M');
//        people.setBirthday(new java.sql.Date(new java.util.Date().getTime()));
//        people.setGraduation(true);
//        people.setTelphone(1234567);
//        people.setMarryTime(new Timestamp(new java.util.Date().getTime()));
//
//        InputStream inputStream = new FileInputStream("/Users/chenjianliang/IdeaProjects/Hibernate/web/detail.jsp");
//        int length = inputStream.available();
//        byte[] buffer = new byte[length];
//        inputStream.read(buffer);
//        people.setFile(buffer);


        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        Iterator<People> iterator = null;
        try {

            transaction = session.beginTransaction();

            /**
             * save
             *
             *             session.save(people);
             *
             * */

            /**
             * get
             *
             *             People people1 = (People) session.get(People.class,9L);
             *             System.out.println("HibernateTest.main "+people1.getUsername());
             * */



            /**
             * listAll query
             *
             *
             *             Query query =  session.createQuery("from People ");
             *             query.list();
             *             for (Object o:query.list()){
             *             System.out.println("HibernateTest.main "+((People)o).getUsername());
             *             }
             *
             * */



            /**
             *
             * delete
             *
             *             Query query = session.createQuery("from People ");
             *             Iterator<People> iterator = (Iterator<People>) query.iterate();
             *             while (iterator.hasNext()){
             *             session.delete(iterator.next());
             }
             * */


            /**  delete
             *
             *             Query query = session.createQuery("from People ");
             List<People> list = query.list();
             for (People people:list){
             session.delete(people);
             }
             * */


            Query query = session.createQuery("from People ");
             iterator = (Iterator<People>) query.iterate();





            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);
        }
//
//            Iterator<People> iterator = (Iterator<People>)query.iterate();
//            while (iterator.hasNext()){
//                session.delete(iterator.next());
//            }
//
////            List<People> list = (List<People>) query.list();
////            for (Iterator<People> iterator = list.iterator();iterator.hasNext();){
////                session.delete(iterator.next());
////            }


        while (iterator.hasNext()){
            System.out.println("HibernateTest.main"+            iterator.next().getId());
        }

    }
}
