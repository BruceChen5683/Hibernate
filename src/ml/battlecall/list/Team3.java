package ml.battlecall.list;

import java.util.HashSet;
import java.util.Set;

public class Team3 {
    private String id;
    private String teamName;
    private Set student3 = new HashSet();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Set getStudent3() {
        return student3;
    }

    public void setStudent3(Set student3) {
        this.student3 = student3;
    }
}
