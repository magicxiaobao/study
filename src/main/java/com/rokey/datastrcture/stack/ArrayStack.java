package com.rokey.datastrcture.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyuejun
 * @date 2018-10-15 11:03 PM
 **/
public class ArrayStack<T> implements IStack<T> {


	private List<T> list = new ArrayList();

	private Integer index = -1;

	@Override
	public void push(T t) {

		list.add(++index, t);
	}

	@Override
	public T pop() {

		return list.remove((index).intValue());
	}

	@Override
	public T peek() {
		return list.get(index);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
}