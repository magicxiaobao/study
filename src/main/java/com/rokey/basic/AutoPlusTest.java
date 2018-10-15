package com.rokey.basic;

/**
 * java的自动增长符号
 * @author chenyuejun
 * @date 2018-03-21 下午5:08
 **/
public class AutoPlusTest {


	public static void main(String[] args) {

		int x = 0, y = 10;

		do {

			y--;
			++x;
		} while (x < 6);

		System.out.println("x= " + x + " y= " + y);
	}

}