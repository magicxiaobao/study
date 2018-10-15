package com.rokey.datastrcture.clone;

import java.util.Arrays;

/**
 * @author chenyuejun
 * @create 2017-08-26 上午10:25.
 */
public class Person implements Cloneable
{


    private String name;

    private int age;

    private int[] number;

    public Person(String name, int age, int[] number) {
        this.name = name;
        this.age = age;
        this.number = Arrays.copyOf(number,number.length);
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

    public int[] getNumber() {
        return number;
    }

    public void setNumber(int[] number) {
        this.number = number;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
