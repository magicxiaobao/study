package com.rokey.thread.interrupt;

/**
 * @author chenyuejun
 * @date 2018-03-22 下午12:42
 **/
public class InterruptTest2 extends Thread {

	volatile boolean isStopped;

	@Override
	public void run() {

		try {

			while(!isStopped) {
				System.out.println("thread is running");
			}
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			System.out.println("be interrupted");
		}
	}

	public static void main(String[] args) throws Exception{

		InterruptTest2 interruptTest2 = new InterruptTest2();
		System.out.println("thread starting");
		interruptTest2.start();
		Thread.sleep(3000);
		System.out.println("ask thread to stop");
		interruptTest2.isStopped = true;
		interruptTest2.interrupt();
		Thread.sleep(3000);
		System.out.println("stop application");
		System.exit(0);

	}
}