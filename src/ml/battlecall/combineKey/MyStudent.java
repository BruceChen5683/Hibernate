package ml.battlecall.combineKey;

import java.io.Serializable;
import java.util.Objects;

public class MyStudent implements Serializable {
    private String cardId;//联合主键
    private String name;//联合主键
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyStudent myStudent = (MyStudent) o;
        return Objects.equals(cardId, myStudent.cardId) &&
                Objects.equals(name, myStudent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, name);
    }
}
