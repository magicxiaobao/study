package com.rokey.datastrcture.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author chenyuejun
 * @create 2018-11-08 11:15 PM
 **/
public class QueueTest {

	@Test
	public void enqueue() {

		Queue<Integer> integerQueue = new Queue<>();
		integerQueue.enqueue(1);
		assertTrue(!integerQueue.isEmpty());
		integerQueue.enqueue(2);
		Integer item = integerQueue.dequeue();
		assertEquals(1, item.intValue());
		assertTrue(!integerQueue.isEmpty());
		integerQueue.dequeue();
		assertTrue(integerQueue.isEmpty());
	}

	@Test
	public void dequeue() {

		Queue<Integer> integerQueue = new Queue<>();
		integerQueue.enqueue(1);
		integerQueue.enqueue(2);
		integerQueue.enqueue(3);
		assertTrue(!integerQueue.isEmpty());
		Integer item1 = integerQueue.dequeue();
		assertEquals(1, item1.intValue());
		Integer item2 = integerQueue.dequeue();
		assertEquals(2, item2.intValue());
		assertFalse(integerQueue.isEmpty());
		integerQueue.dequeue();
		assertTrue(integerQueue.isEmpty());
	}

	@Test
	public void peek() {

		Queue<Integer> integerQueue = new Queue<>();
		integerQueue.enqueue(1);
		Integer i = integerQueue.peek();
		assertEquals(1, i.intValue());
		assertFalse(integerQueue.isEmpty());
	}

	@Test
	public void isEmpty() {

		Queue<Integer> integerQueue = new Queue<>();
		integerQueue.enqueue(1);
		assertFalse(integerQueue.isEmpty());
	}
}