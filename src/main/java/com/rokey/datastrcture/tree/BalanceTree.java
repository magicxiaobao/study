package com.rokey.datastrcture.tree;

/**
 * 平衡树
 *  将二叉树重新排序，不存在 高度比原来的小
 * @author chenyuejun
 * @date 2018-10-28 4:39 PM
 **/
public class BalanceTree {


	/**
	 * 返回树的高度
	 * @param node
	 * @return
	 */
	public static Integer getHeight(TreeNode<Integer> node) {

		if (node == null) {
			return 0;
		}
		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
	}

	/**
	 * 判断是否是平衡树
	 * 此方法时间复杂度为O(NlogN),效率不高
	 * @param node
	 * @return
	 */
	public static boolean isBalanced(TreeNode<Integer> node) {

		if (node == null) {
			return true;
		}
		if (Math.abs(getHeight(node.getLeft()) - getHeight(node.getRight())) > 1) {
			return false;
		} else {
			return isBalanced(node.getLeft()) && isBalanced(node.getRight());
		}
	}


	public static int checkHeight(TreeNode<Integer> root) {

		if (root == null) {
			return -1;
		}
		int leftHeight = checkHeight(root.getLeft());
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = checkHeight(root.getRight());
		if (rightHeight == -1) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	public static boolean isBalanceGood(TreeNode<Integer> root) {

		if (checkHeight(root) == -1) {
			return false;
		}
		return true;
	}

}