package com.rokey.datastrcture.queue;

import com.rokey.datastrcture.Node;

/**
 * @author chenyuejun
 * @date 2018-10-28 5:32 PM
 **/
public class Queue<T> implements IQueue<T>{

	private Node<T> first;

	private Node<T> last;

	@Override
	public void enqueue(T t) {
		if (last == null) {
			last = new Node<>(t);
			first = last;
		} else {
			last.setNext(new Node<>(t));
			last = last.getNext();
		}
	}

	@Override
	public T dequeue() {
		if (first == null) {
			return null;
		}
		T data = first.getData();
		first = first.getNext();
		return data;
	}

	@Override
	public T peek() {
		if (first == null) {
			return null;
		}
		return first.getData();
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}
}