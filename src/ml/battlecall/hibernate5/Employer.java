package ml.battlecall.hibernate5;


/**
 * Created by chenjianliang on 2018/11/5.
 */
public class Employer {
//    SchemaExport cfg.xml 生产ddl sql构造语言
    private String id;
    private String name;
    private EmIDCard emIDCard;
    private Team team;

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

    public EmIDCard getEmIDCard() {
        return emIDCard;
    }

    public void setEmIDCard(EmIDCard emIDCard) {
        this.emIDCard = emIDCard;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
