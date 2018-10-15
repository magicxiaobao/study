package com.rokey.collection.list;

import java.util.LinkedList;

/**
 * @author chenyuejun
 * @date 2018-03-09 下午1:25
 **/
public class LinkedListTest {

	public static void main(String[] args) {

		LinkedList<String> strings = new LinkedList<>();
		strings.add("a");
		strings.add("b");
		System.out.println(strings.peek());
		System.out.println(strings.size());
		System.out.println(strings.poll());
		System.out.println(strings.size());
	}

}