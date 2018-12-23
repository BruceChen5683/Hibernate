package ml.battlecall;

import ml.battlecall.hibernate5.EmIDCard;
import ml.battlecall.hibernate5.Employer;
import ml.battlecall.hibernate5.Team;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.type.Type;

import java.util.HashSet;
import java.util.List;

public class HibernateTest5 {
    public static void main(String[] args) {


        Employer employer = new Employer();
        employer.setName("hy");

        Employer employer1 = new Employer();
        employer1.setName("hyyy");

        EmIDCard emIDCard = new EmIDCard();
        emIDCard.setNumber(999);

        employer.setEmIDCard(emIDCard);
        emIDCard.setEmployer(employer);

        Team team = new Team();
        team.setName("mid");

        team.setEmployers(new HashSet<Employer>());
        team.getEmployers().add(employer);
        team.getEmployers().add(employer1);


        employer.setTeam(team);




        Session session = HibernateUtils.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(team);


            /**
             * //            Team team1 = session.get(Team.class,"ff80818166f0b9520166f0b9534f0000");
             * //
             * //            System.out.println("HibernateTest5.main "+team1.getName());
             *
             *             Employer employer = session.get(Employer.class,"ff80818166f0bacf0166f0bad0b00001");
             */


            /**
             * 离散的值 Object数组
             * Query query = session.createQuery("select s.name,s.id from Employer s");
             *             List list = query.list();
             *             for (int i = 0; i < list.size();i++){
             *                 Object[] obj = (Object[]) list.get(i);
             *                 System.out.println("HibernateTest5.main "+ obj[0] + "  "+obj[1]);
             *             }
             *
             */


            /**
             * 对象  创建合适的构造函数
             *
             * Query query = session.createQuery("select new Employer (s.name,s.id) from Employer s");
             *             List list = query.list();
             *             for (int i = 0;i < list.size();i++){
             *                 Employer employer = (Employer) list.get(i);
             *                 System.out.println("HibernateTest5.main "+employer.getName() + "  "+ employer.getId());
             *                 System.out.println("HibernateTest5.main" +employer.getTeam());
             *             }
             */

            /**
             *  内链接
             *              Query query = session.createQuery("from Team t join t.employers");
             *             List list = query.list();
             *
             *             for (int i =0;i < list.size();i++){
             *                 Object[] obj = (Object[]) list.get(i);
             *                 Team team= (Team) obj[0];
             *                 Employer employer = (Employer) obj[1];
             *
             *                 System.out.println("HibernateTest5.main "+team.getName());
             *                 System.out.println("HibernateTest5.main" +employer.getName());
             *
             *             }
             *
             */


            /**
             * setEnity
             *             Team team = session.get(Team.class,"402881f5677b5adc01677b5ade2b0000");
             *             Query query = session.createQuery("from Employer s where s.team = :myteam");
             *             query.setEntity("myteam",team);
             *             List list = query.list();
             *
             *             System.out.println("HibernateTest5.main "+list.size());
             */


            /**
             *  setParameter??? TOOD  check此方法参数
             *
             *              Team team = session.get(Team.class,"402881f5677b5adc01677b5ade2b0000");
             *             Query query = session.createQuery("from Employer s where s.team = :myteam");
             *             query.setParameter("myteam",team,Hibernate.entity(Team.class));
             *             List list = query.list();
             *
             *             System.out.println("HibernateTest5.main "+list.size());
             *
             */

            /**
             * createFilter
             *
             *             Team team = session.get(Team.class,"402881f5677b5adc01677b5a" +
             *                     "de2b0000");
             *             Query query = session.createFilter(team.getEmployers(),"where name = 'hy'");
             *
             *             List list = query.list();
             *             for (int i = 0; i < list.size();i++){
             *                 Employer employer = (Employer) list.get(i);
             *                 System.out.println("HibernateTest5.main "+employer.getEmIDCard().getNumber());
             *             }
             *
             */


            /**
             *  QBC QBC QBC
             */

//            Criteria criteria = session.createCriteria(Employer.class)//employer整个表
//                            .add(Restrictions.eq("name","hy"))//限制条件 属性名字为hy
//                            .addOrder(Order.desc("id"));//降序
//
//
//            List list = criteria.list();
//
//            for (int i = 0;i < list.size();i++){
//                Employer employer = (Employer) list.get(i);
//                System.out.println("HibernateTest5.main  :"+ employer.getId());
//            }
//            System.out.println("HibernateTest5.main " + list.size());










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
