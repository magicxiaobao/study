package com.rokey.basic;

/**
 * @author chenyuejun
 * @date 2018-03-09 下午12:55
 **/
public class PlusSignTest {

	public static void main(String[] args) {

		boolean x = true;
		boolean y = false;
		short z = 42;
		if ((z++ == 42) && (y == true)) {

			z++;
		}
		if ((x == false) || (++z == 45)) {

			z++;
		}
		System.out.println("z: " + z);
	}



}