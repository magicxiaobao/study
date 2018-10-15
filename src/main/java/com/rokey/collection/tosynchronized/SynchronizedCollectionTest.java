package com.rokey.collection.tosynchronized;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

/**
 * @author chenyuejun
 * @date 2018-03-12 下午2:38
 **/
public class SynchronizedCollectionTest {

	private Collection collection;

	//并发数量
	private int runnerCount;

	@Before
	public void init() {

		runnerCount = 20;
	}

	@Test
	public void hashSetRequestsTest() {

		//具体实现为HashSet
		collection = new HashSet<String>();

		//Rnner数组，想当于并发多少个。
		TestRunnable[] trs = new TestRunnable[runnerCount];
		for (int i = 0; i < runnerCount; i++) {

			// 构造一个Runner
			TestRunnable runner = new CollectionConcurrenceTest(collection);
			trs[i] = runner;
		}
		// 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
		try {
			// 开发并发执行数组里定义的内容
			mttr.runTestRunnables();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		collection.stream().forEach(System.out ::println);
	}

	@Test
	public void testHashSet() {

		collection = new HashSet();
		for (int i=0; i < 20; i++) {

			new Thread(new TestThread(collection)).start();
		}
		try {

			Thread.sleep(2000);
			collection.stream().forEach(System.out :: println);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void testColecctionsSynchronizeCollection() {

		Set<String> strings = Collections.synchronizedSet(new HashSet<String>());
	}

	static class CollectionConcurrenceTest extends TestRunnable {


		private Collection collection;

		public CollectionConcurrenceTest(Collection collection) {

			super();
			this.collection = collection;
		}

		//测试内容
		@Override
		public void runTest() throws Throwable {

			collection.add(Thread.currentThread().getName());
		}
	}

	static class TestThread implements Runnable {

		private Collection collection;

		public TestThread(Collection collection) {
			this.collection = collection;
		}

		public Collection getCollection() {
			return collection;
		}

		public void setCollection(Collection collection) {
			this.collection = collection;
		}

		@Override
		public void run() {

			collection.add(Thread.currentThread().getName());
		}
	}



}