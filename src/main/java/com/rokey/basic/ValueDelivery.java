package com.rokey.basic;

/**
 * @author chenyuejun
 * @date 2018-03-09 下午1:18
 **/
public class ValueDelivery {


	public static void main(String[] args) {

		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		opert(a, b);
		System.out.println(a + ", " + b);
	}

	public static void opert(StringBuffer x, StringBuffer y) {

		x.append(y);
		y = x;
	}
}