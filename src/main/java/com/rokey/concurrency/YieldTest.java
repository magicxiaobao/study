package com.rokey.concurrency;

/**
 * @author chenyuejun
 * @date 2018-03-22 上午10:56
 **/
public class YieldTest extends Thread {

	private String name;

	public YieldTest(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		for (int i = 0; i < 30; i++) {

			System.out.println("name " + name + " i= " + i);
			if (i == 15) {

				Thread.yield();
			}
		}
	}

	public static void main(String[] args) {

		new YieldTest("A").start();
		new YieldTest("B").start();

	}

}