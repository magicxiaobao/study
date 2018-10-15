package com.rokey.hash;

import java.util.HashMap;

/**
 * @author chenyuejun
 * @create 2017-08-28 下午12:39.
 */
public class HashMapTest {


    public static void main(String[] args) {

        //1.先进性垃圾回收
        System.gc();
        //2.获得内存大小
        long start = Runtime.getRuntime().freeMemory();
        //3.新建一个hashMap 往里面放元素
        HashMap hashMap = new HashMap();
        for(int i=0;i<100000000;i++){
            hashMap.put(i,i);
        }
        //4.继续执行垃圾回收，
        System.gc();
        long end = Runtime.getRuntime().freeMemory();
        System.out.println("内存消耗="+(end-start));
    }




}
