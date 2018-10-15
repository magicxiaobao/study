package com.rokey.basic;

/**
 * @author chenyuejun
 * @create 2017-10-31 上午10:03.
 */
public class StringSplitTest {



    public static void main(String[] args) {

        String str = "1,2,,,";
        String[] strings = str.split(",");
        String[] strings1 = str.split(",", -1);
        for (String string : strings) {

            System.out.println(string);

        }
        System.out.println(strings.length);
        System.out.println("00000000");
        for (String string : strings1) {

            System.out.println(string);
        }
        System.out.println(strings1.length);
    }

}
