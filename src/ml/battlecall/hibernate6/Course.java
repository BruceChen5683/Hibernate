package ml.battlecall.hibernate6;

import java.util.Set;

public class Course {
    private String id;
    private String name;
    private Set<Student2> students;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student2> getStudents() {
        return students;
    }

    public void setStudents(Set<Student2> students) {
        this.students = students;
    }
}
