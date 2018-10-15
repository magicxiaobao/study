package com.rokey.datastrcture.graph;

import java.util.Iterator;

/**
 * @author chenyuejun
 * @date 2018-03-31 下午4:15
 **/
public interface VertexInterface<T> {

	T getLabel();

	Iterator<VertexInterface<T>> getNeighborIterator();

	boolean isVisted();
}