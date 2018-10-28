package com.rokey.datastrcture.queue;

/**
 * @author chenyuejun
 * @date 2018-10-28 5:26 PM
 **/
public interface IQueue<T> {


	/**
	 * 入队
	 * @param t
	 */
	void enqueue(T t);

	/**
	 * 出队
	 */
	T dequeue();

	/**
	 * 返回队列首元素
	 * @return
	 */
	T peek();

	/**
	 * 是否为空
	 * @return
	 */
	boolean isEmpty();

}