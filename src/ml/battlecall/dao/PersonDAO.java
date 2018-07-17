package ml.battlecall.dao;

import ml.battlecall.model.Person;

import java.util.List;

/**
 * Created by chenjianliang on 2018/5/29.
 */
public interface PersonDAO {
    void savePerson(Person person);
    List<Person> listAllPersons();
    void removePerson(Integer id);
    Person getSinglePersonById(Integer id);
    void updatePerson(Person person);
}
