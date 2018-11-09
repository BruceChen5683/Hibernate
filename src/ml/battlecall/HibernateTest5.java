package ml.battlecall;

import ml.battlecall.hibernate5.EmIDCard;
import ml.battlecall.hibernate5.Employer;
import ml.battlecall.hibernate5.Team;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;

public class HibernateTest5 {
    public static void main(String[] args) {


//        Employer employer = new Employer();
//        employer.setName("cjl");
//
//        EmIDCard emIDCard = new EmIDCard();
//        emIDCard.setNumber(123456);
//
//        employer.setEmIDCard(emIDCard);
//        emIDCard.setEmployer(employer);
//
//        Team team = new Team();
//        team.setName("mid");
//
//        team.setEmployers(new HashSet<Employer>());
//        team.getEmployers().add(employer);
//
//        employer.setTeam(team);




        Session session = HibernateUtils.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
//            session.save(team);

            System.out.println("HibernateTest5.main  ---");

//            Team team1 = session.get(Team.class,"ff80818166f0b9520166f0b9534f0000");
//
//            System.out.println("HibernateTest5.main "+team1.getName());

            Employer employer = session.get(Employer.class,"ff80818166f0bacf0166f0bad0b00001");

            System.out.println("HibernateTest5.main"+employer.getName());
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
