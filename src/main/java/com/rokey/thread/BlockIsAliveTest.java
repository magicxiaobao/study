package com.rokey.thread;

/**
 * @author chenyuejun
 * @date 2018-03-22 下午2:51
 **/
public class BlockIsAliveTest {


	public static void main(String[] args) {

		Thread thread = new Thread(() -> {

			try {

				Thread.sleep(5000);
				System.out.println("aaaa");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(thread.isAlive());
	}


}