package ml.battlecall.combineKey;

import java.io.Serializable;
import java.util.Objects;

public class StudentPrimaryKey implements Serializable {
    private String cardId;//联合主键
    private String name;//联合主键


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentPrimaryKey that = (StudentPrimaryKey) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, name);
    }
}
