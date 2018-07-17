package ml.battlecall.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by chenjianliang on 2018/7/10.
 */
public class People {
    private Long id;
    private String username;
    private String password;
    private int telphone;
    private char gender;// M F
    private boolean graduation;
    private Date birthday;
    private Timestamp marryTime;
    private byte[] file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTelphone() {
        return telphone;
    }

    public void setTelphone(int telphone) {
        this.telphone = telphone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean isGraduation() {
        return graduation;
    }

    public void setGraduation(boolean graduation) {
        this.graduation = graduation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getMarryTime() {
        return marryTime;
    }

    public void setMarryTime(Timestamp marryTime) {
        this.marryTime = marryTime;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telphone=" + telphone +
                ", gender=" + gender +
                ", graduation=" + graduation +
                ", birthday=" + birthday +
                ", marryTime=" + marryTime +
                ", file=" + Arrays.toString(file) +
                '}';
    }
}
