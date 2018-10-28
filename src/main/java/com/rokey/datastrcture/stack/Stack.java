package com.rokey.datastrcture.stack;

import com.rokey.datastrcture.Node;

/**
 * @author chenyuejun
 * @date 2018-10-23 8:27 PM
 **/
public class Stack<T> implements IStack<T>{


	private Node<T> top;

	/**
	 * 入栈
	 * @param t
	 */
	@Override
	public void push(T t) {

		if (top == null) {
			top = new Node<>(t);
		} else {
			Node<T> add = new Node<>(t);
			add.next = top;
			top = add;
		}
	}

	/**
	 * 出栈
	 * @return
	 */
	@Override
	public T pop() {

		if (top == null) {
			return null;
		} else {
			Node<T> temp = top;
			top = top.next;
			return temp.getData();
		}
	}

	/**
	 * 返回栈顶元素，但不出栈
	 * @return
	 */
	@Override
	public T peek() {

		return top != null ? top.getData() : null;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}


}