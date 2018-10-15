package com.rokey.basic;

import java.util.Scanner;

/**
 * @author chenyuejun
 * @date 2018-03-23 上午10:57
 **/
public class ScannerTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入数字!");
		//调用下面的方法 就阻塞了
		String next = scanner.next();
		System.out.println(next);
	}

}