package com.rokey.compare;

/**
 * @author chenyuejun
 * @create 2017-08-26 下午12:22.
 */
public class Apple implements Comparable<Apple> {


    private int size;

    private String name;

    public Apple(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Apple o) {
        return this.getSize()-o.getSize();
    }
}
