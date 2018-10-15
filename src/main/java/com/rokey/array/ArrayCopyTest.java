package com.rokey.array;

import java.util.Arrays;

/**
 * @author chenyuejun
 * @date 2018-03-09 下午1:38
 **/
public class ArrayCopyTest {

	public static void main(String[] args) {

		String[] strings = {"a", "b", "c"};
		String[] strings1 = Arrays.copyOf(strings, 5);
		System.out.println(strings1.length);
		for (String s : strings1) {

			System.out.println(s);
		}
	}

}