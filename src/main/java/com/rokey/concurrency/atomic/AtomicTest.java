package com.rokey.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author chenyuejun
 * @date 2018-03-13 上午11:58
 **/
public class AtomicTest {


	public static void main(String[] args) {

		AtomicInteger atomicInteger = new AtomicInteger();
		atomicInteger.compareAndSet(0, 3);
		atomicInteger.set(88);
		System.out.println(atomicInteger.get());

		AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(5);
		atomicIntegerArray.addAndGet(0, 1);
		System.out.println(atomicIntegerArray.addAndGet(2, 2));
		System.out.println(atomicIntegerArray.get(0));
	}

}