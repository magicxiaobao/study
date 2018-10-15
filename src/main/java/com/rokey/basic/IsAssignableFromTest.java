package com.rokey.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyuejun
 * @create 2018-01-08 下午11:53
 **/
public class IsAssignableFromTest {


	public static void main(String[] args) {

		ArrayList<String> strings = new ArrayList<>();
		System.out.println(strings instanceof List);
		System.out.println("-------");
		System.out.println(strings.getClass().isAssignableFrom(List.class));
		System.out.println(List.class.isAssignableFrom(strings.getClass()));

	}

}
