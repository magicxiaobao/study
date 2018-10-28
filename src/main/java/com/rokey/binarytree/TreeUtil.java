package com.rokey.binarytree;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 递归遍历节点,构建树
 * @author chenyuejun
 * @date 2018-07-02 下午5:23
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TreeUtil {


	public static <T, E> TreeNode<T, E> buildTree(List<TreeNode<T, E>> nodes, E rootId) {

		if(CollectionUtils.isEmpty(nodes)) {

			return null;
		}

		if(getRoot(nodes, rootId) == null) {
			System.out.println("未找到根节点");
			return null;
		}

		return null;
	}

	public static <T, E> TreeNode<T, E> getRoot(List<TreeNode<T, E>> nodes, E rootId) {

		return nodes.stream().filter(node -> node.getParentId().equals(rootId)).findFirst().orElse(null);
	}

	public static <T, E> TreeNode<T, E> build(List<TreeNode<T, E>> nodes, TreeNode<T, E> root) {

		nodes.forEach(node -> {

			if(node.getParentId().equals(root.getId())) {

				root.addChild(node);
				build(nodes, node);
			}
		});
		return root;
	}

	/**
	 * 转换成list
	 * @param datas
	 * @param node
	 * @param include
	 * @param <T>
	 * @param <E>
	 * @return
	 */
	public static <T, E> List<T> toList(List<T> datas, TreeNode<T, E> node, boolean include) {

		if(include) {

			datas.add(node.getData());
		}
		if(!node.hasChild()) {

			return datas;
		}
		node.getChildren().forEach(child -> toList(datas, child, true));

		return datas;
	}

}