package com.rokey.datastrcture.tree;

/**
 * 树的遍历搜索
 * 前序 当前节点->左节点->右节点
 * 中序 左节点->当前节点->有节点
 * 后序 做节点->有节点->当前节点
 * @author chenyuejun
 * @date 2018-10-28 2:51 PM
 **/
public class TreeSearch<T> {


	/**
	 * 前序查找
	 * @param node
	 * @param data
	 */
	public void preOrderTraversal(TreeNode<T> node, T data) {

		if (node == null) {
			return;
		}

		if (node.getData().equals(data)) {
			return;
		}

		preOrderTraversal(node.getLeft(), data);

		preOrderTraversal(node.getRight(), data);

	}

	/**
	 * 中序查找
	 * @param node
	 * @param data
	 */
	public void inOrderTraversal(TreeNode<T> node, T data) {

		if (node == null) {
			return;
		}
		inOrderTraversal(node.getLeft(), data);

		if (node.getData().equals(data)) {
			return;
		}
		inOrderTraversal(node.getRight(), data);

	}

	/**
	 * 后序查找
	 * @param node
	 * @param data
	 */
	public void postOrderTraversal(TreeNode<T> node, T data) {

		if (node == null) {
			return;
		}
		postOrderTraversal(node.getLeft(), data);
		postOrderTraversal(node.getRight(), data);
		if (node.getData().equals(data)) {
			return;
		}

	}

}