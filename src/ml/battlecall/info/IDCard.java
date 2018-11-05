package ml.battlecall.info;

/**
 * Created by chenjianliang on 2018/11/5.
 */
public class IDCard {
    private String id;
    private String number;
    private Student student;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
