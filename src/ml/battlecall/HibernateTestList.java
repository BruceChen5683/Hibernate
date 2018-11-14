package ml.battlecall;

import ml.battlecall.hibernateMap.Team2;
import ml.battlecall.list.Team3;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Map;

public class HibernateTestList {
    public static void main(String[] args) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();

            Team3 team3 = new Team3();
            team3.setTeamName("teamList");


            team3.getStudent3().add("zhangsan");
            team3.getStudent3().add("liai");
            team3.getStudent3().add("xxx");



            session.save(team3);

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
