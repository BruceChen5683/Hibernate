package ml.battlecall.action;

import com.opensymphony.xwork2.ActionSupport;
import ml.battlecall.model.Person;
import ml.battlecall.service.PersonService;
import ml.battlecall.service.impl.PersonServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by chenjianliang on 2018/5/29.
 */
public class PersonAction extends ActionSupport {

    private int id;
    private String username;
    private String password;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String savePerson() throws Exception {
        Person person = new Person();
        person.setAge(age);
        person.setPassword(password);
        person.setUsername(username);

        System.out.println("PersonAction.savePerson "+password);
        Date registerDate = new Date(new java.util.Date().getTime());
        person.setRegisterDate(registerDate);


        PersonService personService = new PersonServiceImpl();
        personService.savePerson(person);

        List<Person> list = personService.listAllPersons();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list",list);

        return SUCCESS;
    }

    public String deletePerson() throws Exception{

        PersonService personService = new PersonServiceImpl();
        personService.removePerson(id);

        List<Person> list = personService.listAllPersons();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list",list);

        return SUCCESS;
    }

    public String getSinglePerson() throws Exception{
        PersonService personService = new PersonServiceImpl();
        Person person = personService.getSinglePersonById(id);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("person",person);
        return SUCCESS;
    }

    public String updatePerson() throws Exception{
        PersonService personService = new PersonServiceImpl();
        Person person = personService.getSinglePersonById(id);
        person.setAge(age);
        person.setPassword(password);
        personService.updatePerson(person);

        List<Person> list = personService.listAllPersons();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list",list);

        return SUCCESS;


    }

}
