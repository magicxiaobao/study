package com.rokey.basic;

/**
 * String类的一些基础说明
 *
 * @author chenyuejun
 * @date 2018-03-08 下午2:05
 **/
public class StringTest {

	public static void main(String[] args) {

		//String 对象创建的一种特别方式
		String s = new String("abc");
		System.out.println(s == "abc");
		//编译器优化，合并已知量，引用指向常量池中的"ab"
		String ab = "a" + "b";
		System.out.println(ab == "ab");

		final String s1 = "a";
		String b = s1 + "b";
		System.out.println(b == "ab");

		String s2 = "a";
		String b2 = s2 + "b";
		System.out.println(b2 == "ab");

		String s3 = "abc".substring(0, 2);
		System.out.println(s3 == "ab");

		String s4 = "abc".toUpperCase();
		System.out.println(s4 == "ABC");

		String s5 = "abc";
		String s6 = s5;
		System.out.println(s6 == "abc");
		s5 = s5 + "hello";
		System.out.println(s6 == "abc");
		System.out.println(s5 == "abchello");

		System.out.println(new String("AB").getBytes().length);
	}

}