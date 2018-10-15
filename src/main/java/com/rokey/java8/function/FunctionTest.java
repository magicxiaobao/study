package com.rokey.java8.function;

import java.util.function.Function;

/**
 * Function<T, R> T作为输入 R作为输出
 * @author chenyuejun
 * @create 2018-01-08 下午11:23
 **/
public class FunctionTest {


	public static void main(String[] args) {

		Function<String, String> function = String::toString;
		System.out.println(function.apply("abc"));
		Function<Integer, String> function1 = (i) -> i.toString();
		System.out.println(function1.apply(2));
	}

}
