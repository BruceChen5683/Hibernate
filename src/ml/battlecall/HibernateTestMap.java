package ml.battlecall;

import ml.battlecall.hibernateMap.Team2;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Map;

public class HibernateTestMap {
    public static void main(String[] args) {

        Session session = HibernateUtils.openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();

            Team2 team2 = new Team2();
            team2.setTeamName("team");

            Map map = team2.getStudents();
            map.put("zhangsan","hi");
            map.put("lisi","haha");


            session.save(team2);

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
