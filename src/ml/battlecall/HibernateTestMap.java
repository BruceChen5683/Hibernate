package ml.battlecall;

import ml.battlecall.hibernateMap.Team2;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class HibernateTestMap {
    public static void main(String[] args) {

        Session session = HibernateUtils.openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();

            /**
             * save
             *
             *
             *
             */
//                        Team2 team2 = new Team2();
//                          team2.setTeamName("team");
//
//                          Map map = team2.getStudents();
//                          map.put("zhangsan","hi");
//                          map.put("lisi","haha");
//                          map.put("cc","haha");
//                          map.put("bb","haha");
//
//
//                          session.save(team2);



            /**
             * query get a uniqueResult
             */

            Team2 team2 = (Team2) session.createQuery("from Team2 t where t.teamName = 'team'").uniqueResult();
            Map map = team2.getStudents();

            Collection collection = map.keySet();

            Iterator iterator = collection.iterator();
            while (iterator.hasNext()){

                System.out.println("HibernateTestMap.main  "+                iterator.next());
            }


//            /**
//             * query get a list
//             */
//
//            for (Object team2 :session.createQuery("from Team2 t where t.teamName = 'team'").list()){
//                Map map = ((Team2)team2).getStudents();
//
//                Collection collection = map.keySet();
//
//                Iterator iterator = collection.iterator();
//                while (iterator.hasNext()){
//
//                    System.out.println("HibernateTestMap.main  "+                iterator.next());
//                }
//
//            }



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
