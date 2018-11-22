package com.rokey.concurrency;

/**
 * @author chenyuejun
 * @date 2018-03-14 下午10:15
 **/
public class DeadLockTest {

	public static void main(String[] args) {

		new Thread(new DeadClock(true)).start();
		new Thread(new DeadClock(false)).start();
	}

	static class DeadClock implements Runnable {

		private static Object o1 = new Object();

		private static Object o2 = new Object();

		private boolean flag;

		public DeadClock(boolean flag) {
			this.flag = flag;
		}

		@Override
		public void run() {

			if (isFlag()) {
				synchronized (o1) {

					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (o2) {

						System.out.println(Thread.currentThread().getName() + "syno2");

					}
				}

			}

			if (!isFlag()) {

				synchronized (o2) {

					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (o1) {

						System.out.println(Thread.currentThread().getName() + "syno1");

					}
				}

			}
		}

		public boolean isFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}
	}

}