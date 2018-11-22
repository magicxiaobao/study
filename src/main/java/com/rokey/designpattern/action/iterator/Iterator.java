package com.rokey.designpattern.action.iterator;

/**
 * Iterator模式
 * @author chenyuejun
 * @date 2018-11-14 8:15 PM
 **/
public interface Iterator<T> {


	boolean hasNext();

	T next();

}