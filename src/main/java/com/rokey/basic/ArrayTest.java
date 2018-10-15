package com.rokey.basic;

/**
 * 数组测试
 *
 * @author chenyuejun
 * @date 2018-03-08 下午1:51
 **/
public class ArrayTest {

	public ArrayTest() {

		System.out.println("Constructor Method of ArrayTest");
	}

	public static void main(String[] args) {

		char[] char1 = new char[]{'a', 'b', 'c'};
		char[][] char2 = new char[][]{{'1', '2', '3'}, {'A', 'B', 'C'}};
		System.out.println(char2[1][0]);
	}


}