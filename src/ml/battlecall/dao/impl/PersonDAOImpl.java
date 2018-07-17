package ml.battlecall.dao.impl;

import ml.battlecall.dao.PersonDAO;
import ml.battlecall.model.Person;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by chenjianliang on 2018/5/29.
 */
public class PersonDAOImpl implements PersonDAO{
    @Override
    public void savePerson(Person person) {
        Session session = HibernateUtils.openSession();//save(person);
        Transaction transaction = session.beginTransaction();

        try {
            session.save(person);
            transaction.commit();
        }catch (Exception e){
            if (null != transaction){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);
        }
    }

    @Override
    public List<Person> listAllPersons() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<Person> list = null;
        try {
            //Person是类的名字，不是表的名字  既然是类的名字就要严格区分大小写   HQL
            Query query = session.createQuery("from  Person ");
//            query.getResultList();
//
//            for (Object o:query.getResultList()){
//                System.out.println("PersonDAOImpl.listAllPersons "+o);
//            }

            list = (List<Person>) query.list();

            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
            if (null != transaction){
                transaction.rollback();
            }

        }finally {
            HibernateUtils.close(session);
        }
        return list;
    }

    @Override
    public void removePerson(Integer id) {
        Session session = HibernateUtils.openSession();

        Transaction transaction = session.beginTransaction();
        try{
            Person person = (Person) session.get(Person.class,id);
            session.delete(person);
            transaction.commit();
        }catch (Exception e){
            if (null != transaction){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);
        }
    }

    @Override
    public Person getSinglePersonById(Integer id) {
        Person person = null;
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            person = (Person) session.get(Person.class,id);
            transaction.commit();
        }catch (Exception e){
            if (null != transaction){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);
        }
        return person;
    }

    @Override
    public void updatePerson(Person person) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        try {

            session.update(person);
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
