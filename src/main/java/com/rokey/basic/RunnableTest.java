package com.rokey.basic;

/**
 * @author chenyuejun
 * @date 2018-03-09 下午1:01
 **/
public class RunnableTest implements Runnable {

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " Runnable is Running.");
	}

	public static void main(String[] args) {

		Thread thread = new Thread(new RunnableTest());
		thread.run();
		thread.run();
		thread.start();
	}
}