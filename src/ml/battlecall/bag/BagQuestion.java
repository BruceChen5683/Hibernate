package ml.battlecall.bag;

import ml.battlecall.list.Item;

import java.util.List;

public class BagQuestion {
    private String id;
    private String name;
    private List<BagItem> items;

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

    public List getItems() {
        System.out.println("Question.getItems ");
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}
