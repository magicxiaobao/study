package com.rokey.datastrcture.graph;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author chenyuejun
 * @date 2018-03-31 下午3:49
 **/
public class Vertex<T> implements VertexInterface<T>, Serializable {

	private static final long serialVersionUID = 1L;

	private T label;

	private List<Edge> edgeList;

	private boolean visted;

	private VertexInterface<T> previousVertex;

	private double cost;

	public Vertex(T label) {

		this.label = label;
		this.edgeList = new LinkedList<>();
		this.visted = false;
		this.previousVertex = null;
		this.cost = 0;
	}

	@Override
	public T getLabel() {

		return label;
	}

	@Override
	public Iterator<VertexInterface<T>> getNeighborIterator() {

		return new NeighborIterator();
	}

	@Override
	public boolean isVisted() {

		return visted;
	}

	public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
		// 将"边"(边的实质是顶点)插入顶点的邻接表
		boolean result = false;
		if(!this.equals(endVertex)){//顶点互不相同

			Iterator<VertexInterface<T>> neighbors = this.getNeighborIterator();
			boolean duplicateEdge = false;
			while(!duplicateEdge && neighbors.hasNext()){//保证不添加重复的边
				VertexInterface<T> nextNeighbor = neighbors.next();
				if(endVertex.equals(nextNeighbor)){
					duplicateEdge = true;
					break;
				}
			}
			if(!duplicateEdge){

				edgeList.add(new Edge(endVertex, edgeWeight));//添加一条新边
				result = true;
			}
		}
		return result;
	}

	public boolean connect(VertexInterface<T> endVertex) {

		return connect(endVertex, 0);
	}

	public boolean hasPreProcessor() {

		return this.previousVertex != null;
	}

	public VertexInterface<T> getPreviousVertex() {

		return this.previousVertex;
	}

	public double getCost() {

		return cost;
	}

	public void setCost(double cost) {

		this.cost = cost;
	}

	@Override
	public boolean equals(Object other) {

		boolean result;
		if (this == other) {

			return true;
		}
		if (other == null || getClass() != other.getClass()) {

			result = false;
		} else {

			Vertex<T> vertex = (Vertex<T>) other;
			result = this.label.equals(vertex.label);
		}
		return result;
	}

	private class Edge implements Serializable {

		private VertexInterface<T> vertex;

		private double weight;

		public Edge(VertexInterface<T> vertex, double weight) {

			this.vertex = vertex;
			this.weight = weight;
		}

		private VertexInterface<T> getEndVertex() {

			return vertex;
		}

		public double getWeight() {

			return weight;
		}
	}

	private class NeighborIterator implements Iterator<VertexInterface<T>> {

		private Iterator<Edge> edgeIterator;

		public NeighborIterator() {

			this.edgeIterator = edgeList.iterator();
		}

		@Override
		public boolean hasNext() {

			return edgeIterator.hasNext();
		}

		@Override
		public VertexInterface<T> next() {

			VertexInterface<T> nextNeighbor = null;
			if (edgeIterator.hasNext()) {

				Edge next = edgeIterator.next();
				nextNeighbor = next.getEndVertex();
			} else {

				throw new NoSuchElementException();
			}
			return nextNeighbor;
		}

		@Override
		public void remove() {

			throw new UnsupportedOperationException();
		}
	}

	private class WeightIterator implements Iterator{

		private Iterator<Edge> edgesIterator;
		private WeightIterator(){
			edgesIterator = edgeList.iterator();
		}
		@Override
		public boolean hasNext() {
			return edgesIterator.hasNext();
		}
		@Override
		public Object next() {
			Double result;
			if(edgesIterator.hasNext()){
				Edge edge = edgesIterator.next();
				result = edge.getWeight();
			} else {

				throw new NoSuchElementException();
			}
			return (Object)result;//从迭代器中取得结果时,需要强制转换成Double
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}