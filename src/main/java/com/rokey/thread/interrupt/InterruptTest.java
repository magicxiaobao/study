package com.rokey.thread.interrupt;

/**
 * 参考：http://blog.csdn.net/canot/article/details/51087772
 * @author chenyuejun
 * @date 2018-03-22 下午12:03
 **/
public class InterruptTest {

	public static void main(String[] args) {

		Thread inturrpedThread = new Thread(() -> {

			while (true) {

				if (Thread.currentThread().isInterrupted()) {

					System.out.println("someone interrupted me");
				} else {

					System.out.println("running");
				}
			}
		});
		inturrpedThread.start();
		try {
			Thread.sleep(3000);
			inturrpedThread.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}