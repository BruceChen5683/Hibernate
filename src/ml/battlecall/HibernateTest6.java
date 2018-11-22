package ml.battlecall;

import ml.battlecall.hibernate6.Course;
import ml.battlecall.hibernate6.Student2;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;

public class HibernateTest6 {
    public static void main(String[] args) {


        Student2 student2 = new Student2();
        student2.setName("cjl");
        Course course = new Course();
        course.setName("math");
        student2.setCourses(new HashSet<>());
        student2.getCourses().add(course);
        course.setStudents(new HashSet<>());
        course.getStudents().add(student2);




        Session session = HibernateUtils.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(student2);


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
