package com.rokey.datastrcture;

/**
 * @author chenyuejun
 * @date 2018-10-23 8:28 PM
 **/
public class Node<T> {


	T data;

	Node<T> next;

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

}