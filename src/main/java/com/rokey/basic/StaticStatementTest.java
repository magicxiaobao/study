package com.rokey.basic;

/**
 * @author chenyuejun
 * @create 2017-09-26 上午9:31.
 */
public class StaticStatementTest {


    private static String hello = "HelloWorld!";

    static {


        System.out.println("static statement run");

    }

    public StaticStatementTest() {

        System.out.println("constructor run");
    }

    public static void staticMethod(){

        System.out.println("static Method Run");
    }

    public String objectMethod(){

        return "object Method Run";
    }

    public static void main(String[] args) {

        System.out.println("hahah");
    }

}
