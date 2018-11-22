package com.rokey.concurrency.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 放入数据的线程间隔时间 如果比 取数据的线程时间间隔短 则数组里的数据经常是0
 *
 *                                            长 则数组里的数据经常是3
 * @author chenyuejun
 * @date 2018-03-13 下午6:22
 **/
public class BlockingQueueTest {

	public static void main(String[] args) {

		ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

		for (int i = 0; i < 2; i++) {

			new Thread(() -> {

				while (true) {

					try {

						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + "准备放数据");
						arrayBlockingQueue.put(1);
						System.out.println("放入数据后，数组数据总数: " + arrayBlockingQueue.size());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}).start();
		}

		new Thread(() -> {

			while (true) {

				try {

					Thread.sleep(3000);
					System.out.println(Thread.currentThread().getName() + "准备取数据");
					arrayBlockingQueue.take();
					System.out.println("取走数据后，数据数据总数: " + arrayBlockingQueue.size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

}