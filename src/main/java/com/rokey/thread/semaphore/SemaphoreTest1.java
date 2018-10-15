package com.rokey.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 控制方法允许被并发访问的线程的数量
 * @author chenyuejun
 * @date 2018-03-14 下午8:23
 **/
public class SemaphoreTest1 {

	private static Semaphore semaphore = new Semaphore(5, true);

	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {

			new TestThread().start();
		}

	}

	static class TestThread extends Thread {

		@Override
		public void run() {

			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + "进来了");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "出去了");
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}