package ml.battlecall.service.impl;

import ml.battlecall.dao.PersonDAO;
import ml.battlecall.dao.impl.PersonDAOImpl;
import ml.battlecall.model.Person;
import ml.battlecall.service.PersonService;

import java.util.List;

/**
 * Created by chenjianliang on 2018/5/29.
 */
public class PersonServiceImpl implements PersonService{
    @Override
    public void savePerson(Person person) {
        PersonDAO personDAO = new PersonDAOImpl();
        personDAO.savePerson(person);
    }

    @Override
    public List<Person> listAllPersons() {
        PersonDAO personDAO = new PersonDAOImpl();
        return personDAO.listAllPersons();
    }

    @Override
    public void removePerson(Integer id) {
        PersonDAO personDAO = new PersonDAOImpl();
        personDAO.removePerson(id);
    }

    @Override
    public Person getSinglePersonById(Integer id) {
        PersonDAO personDAO = new PersonDAOImpl();
        return personDAO.getSinglePersonById(id);
    }

    @Override
    public void updatePerson(Person person) {
        PersonDAO personDAO = new PersonDAOImpl();
        personDAO.updatePerson(person);
    }
}
