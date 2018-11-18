package ml.battlecall.bag;

import ml.battlecall.list.Question;

public class BagItem {
    private String id;
    private String name;
    private BagQuestion question;

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

    public BagQuestion getQuestion() {
        return question;
    }

    public void setQuestion(BagQuestion question) {
        this.question = question;
    }
}
