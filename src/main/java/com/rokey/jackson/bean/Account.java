package com.rokey.jackson.bean;

/**
 * @author chenyuejun
 * @create 2017-09-21 下午2:44.
 */
public class Account {

    private String name;

    private String sex;

    private Birthday birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
