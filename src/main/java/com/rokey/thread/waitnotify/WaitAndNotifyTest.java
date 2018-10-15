package com.rokey.thread.waitnotify;

/**
 * @author chenyuejun
 * @date 2018-03-13 上午10:22
 **/
public class WaitAndNotifyTest {


	public static void main(String[] args) {

		Business business = new Business();

		new Thread() {

			@Override
			public void run() {

				for (int i = 0; i < 3; i++) {

					business.subThreadRun();
				}
			}
		}.start();

		for (int i = 0; i < 3; i++) {

			business.mainThreadRun();
		}
	}

}


class Business {

	private boolean subFlag = true;

	public synchronized void mainThreadRun() {

		while (subFlag) {

			try {

				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		for (int i = 0; i < 5; i++) {

			System.out.println("main Thread Running");
		}
		subFlag = true;
		notify();
	}

	public synchronized  void subThreadRun() {

		while (!subFlag) {

			try {

				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		for (int i = 0; i < 10; i++) {

			System.out.println("sub Thread Running");
		}
		subFlag = false;
		notify();
	}
}