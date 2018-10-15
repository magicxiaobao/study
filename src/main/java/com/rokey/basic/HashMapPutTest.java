package com.rokey.basic;

import java.util.HashMap;

/**
 * 测试HashMap的PutAbsent方法
 *
 * @author
 * @create 2017-11-20 下午10:33
 **/
public class HashMapPutTest {

	public static void main(String[] args) {

		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.putIfAbsent("a", "A");
		String str = hashMap.putIfAbsent("a", "B");
		String str2 = hashMap.putIfAbsent("b", "C");
		System.out.println(hashMap.get("a"));
		System.out.println(str);
		System.out.println(str2);
		String str3 = hashMap.putIfAbsent("b", "E");
		System.out.println(str3);
		hashMap.putIfAbsent("c", "G");
		System.out.println(hashMap.get("c"));
	}
}
