package ml.battlecall.hibernate5;


/**
 * Created by chenjianliang on 2018/11/5.
 */
public class EmIDCard {
    private String id;
    private int number;
    private Employer employer;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
