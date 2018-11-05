package ml.battlecall.info;

/**
 * Created by chenjianliang on 2018/11/5.
 */
public class Student {
//    SchemaExport cfg.xml 生产ddl sql构造语言
    private String id;
    private String name;
    private IDCard idCard;

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

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
