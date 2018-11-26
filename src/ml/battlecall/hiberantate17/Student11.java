package ml.battlecall.hiberantate17;

import java.util.HashSet;
import java.util.Set;

public class Student11 {
    private String name;
    private String address;
    private Set contacts = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set getContacts() {
        return contacts;
    }

    public void setContacts(Set contacts) {
        this.contacts = contacts;
    }
}
