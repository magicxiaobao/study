package com.rokey.compare;

import java.util.Arrays;

/**
 * @author chenyuejun
 * @create 2017-08-26 下午12:28.
 */
public class CompareTest {


    public static void main(String[] args) {
        Apple[] apples = new Apple[3];
        apples[0] = new Apple(1,"第一个苹果");
        apples[1] = new Apple(5,"第二个苹果");
        apples[2] = new Apple(3,"第三个苹果");
        Arrays.sort(apples);
        for(Apple apple:apples){
            System.out.println("size:"+apple.getSize()+"name:"+apple.getName());
        }
    }




}
