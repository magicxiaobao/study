package com.rokey.inheritance;

/**
 * @author chenyuejun
 * @create 2017-10-17 下午10:54.
 */
public class FatherClass {

    private String name;

    private String age;

    public FatherClass() {

        System.out.println("FatherClass Constructor withOut parameter");
    }

    public FatherClass(String name) {

        this.name = name;
        System.out.println("FatherClass Constructor with Name parameter");
    }
}
