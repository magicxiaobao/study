package com.rokey.binarytree;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenyuejun
 * @create 2017-08-26 下午1:06.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode<T, E> {

	private E id;

	private E parentId;

	private T data;

	private List<TreeNode<T ,E>> children = new ArrayList<>();

	public TreeNode(T data) {
		this.data = data;
	}

	public void addChild(TreeNode<T, E> child) {

		this.children.add(child);
	}

	public boolean hasChild() {

		return this.children != null && !this.children.isEmpty();
	}
}
