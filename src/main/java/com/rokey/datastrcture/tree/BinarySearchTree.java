package com.rokey.datastrcture.tree;

/**
 * 判断是否是二叉树
 * 所有左子树节点都小于根节点，所有右子树的节点都大于根节点
 * @author chenyuejun
 * @date 2018-10-28 3:58 PM
 **/
public class BinarySearchTree {

	/**
	 * 检查是否是二叉树
	 * @param node
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean checkBinaryTreeMinMax(TreeNode<Integer> node, Integer min, Integer max) {

		if (node == null) {
			return true;
		}
		if (node.getData() > max || node.getData() <= min) {
			return false;
		}
		if (!checkBinaryTreeMinMax(node.getLeft(), min, node.getData()) || !checkBinaryTreeMinMax(node.getRight(), node.getData(), max)) {
			return false;
		}
		return true;
	}

	public static boolean checkBinaryTree(TreeNode<Integer> node) {

		return checkBinaryTreeMinMax(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

}