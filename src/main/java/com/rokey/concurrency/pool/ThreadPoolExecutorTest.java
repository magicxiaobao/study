package com.rokey.concurrency.pool;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * @author chenyuejun
 * @date 2018-03-10 下午1:36
 **/
public class ThreadPoolExecutorTest {


	public static void main(String[] args) {

		ExecutorService pool = Executors.newFixedThreadPool(2);

		pool.execute(new TestThread());
		pool.execute(new TestThread());
		pool.execute(new TestThread());
		pool.execute(new TestThread());

		pool.shutdown();

		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

		scheduledExecutorService.execute(new TestThread());
		scheduledExecutorService.execute(new TestThread());
		scheduledExecutorService.execute(new TestThread());

		scheduledExecutorService.schedule(new TestThread(), 5, TimeUnit.SECONDS);
		scheduledExecutorService.schedule(new TestThread(), 7, TimeUnit.SECONDS);

		scheduledExecutorService.shutdown();




	}

	@Test
	public void futureTest() throws ExecutionException, InterruptedException {

		ExecutorService pool = Executors.newFixedThreadPool(2);
		Future<?> submit = pool.submit(new TestThread());
		System.out.println(submit.get());
		pool.shutdown();

	}

	@Test
	public void callAbleTest() {

		ExecutorService pool = Executors.newFixedThreadPool(2);

		Future<String> submit = pool.submit(new CallableTest());

		try {
			System.out.println(submit.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		pool.shutdown();

	}

	@Test
	public void invokeAnyTest() {

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		HashSet<Callable<String>> callableHashset = new HashSet<Callable<String>>();

		callableHashset.add(new CallableTest());
		callableHashset.add(new CallableTest());
		callableHashset.add(new CallableTest());
		try {

			String s = executorService.invokeAny(callableHashset);
			System.out.println(s);
			executorService.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void invokeAllTest() {

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		HashSet<Callable<String>> callableHashset = new HashSet<Callable<String>>();

		callableHashset.add(new CallableTest());
		callableHashset.add(new CallableTest());
		callableHashset.add(new CallableTest());
		try {

			List<Future<String>> futures = executorService.invokeAll(callableHashset);
			futures.forEach(future -> {
				try {
					System.out.println(future.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			});
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	static class TestThread extends Thread {

		@Override
		public void run() {

			System.out.println(Thread.currentThread().getName());
		}
	}

	static class CallableTest implements Callable<String> {

		@Override
		public String call() {

			return Thread.currentThread().getName();
		}
	}
}