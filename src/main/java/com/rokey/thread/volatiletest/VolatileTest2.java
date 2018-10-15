package com.rokey.thread.volatiletest;

/**
 * @author chenyuejun
 * @date 2018-03-10 上午11:26
 **/
public class VolatileTest2 {


	public static void main(String[] args) {

		ThreadDemo threadDemo = new ThreadDemo();
		new Thread(threadDemo).start();
		while (true) {

			if (threadDemo.isActived()) {

				System.out.println("0000000");
				break;
			}
		}
	}


	static class ThreadDemo implements Runnable {

		private volatile boolean actived = false;
		@Override
		public void run() {

			try {

				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			actived = true;
			System.out.println("isActived: " + actived);
		}

		public boolean isActived() {

			return actived;
		}

		public void setActived(boolean actived) {

			this.actived = actived;
		}
	}

}