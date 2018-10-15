package com.rokey.jackson.bean;

/**
 * @author chenyuejun
 * @create 2017-09-21 下午2:44.
 */
public class Birthday {

    private String birthday;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "birthday='" + birthday + '\'' +
                '}';
    }
}
