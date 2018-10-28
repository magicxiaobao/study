package com.rokey.datastrcture.stack;

/**
 * 栈的接口
 * @author chenyuejun
 * @date 2018-10-15 10:58 PM
 **/
public interface IStack<T> {


	/**
	 * 入栈
	 * @param t
	 */
	void push(T t);


	/**
	 * 出栈
	 * @return
	 */
	T pop();

	/**
	 * 返回栈顶元素，但不出栈
	 * @return
	 */
	T peek();


	/**
	 * 有无元素
	 * @return
	 */
	boolean isEmpty();

}