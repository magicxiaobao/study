package com.rokey.concurrency;

/**
 * @author chenyuejun
 * @date 2018-03-09 下午4:35
 **/
public class SynchronizedTest {

	public synchronized void test() {

		System.out.println("invoke synchronized function");
	}

	public void test2() {

		System.out.println("invoke common function");
	}




}