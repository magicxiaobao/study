package com.rokey.exception;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author chenyuejun
 * @create 2017-08-29 下午11:40.
 */
public class Test1 {


    @Test(expected = IndexOutOfBoundsException.class)
    public void testException(){

        new ArrayList<Object>().get(0);

    }





}
