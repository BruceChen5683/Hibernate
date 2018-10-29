package ml.battlecall.reflect;

import java.util.Set;

/**
 * Created by chenjianliang on 2018/10/10.
 */
public class Customer {
    private Long id;
    private String name;
    //Set List 配置方式不一样
    private Set<Order> orders;//一对多   Set存储是用hashcode无顺序

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
