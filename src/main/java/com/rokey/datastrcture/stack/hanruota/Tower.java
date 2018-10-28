package com.rokey.datastrcture.stack.hanruota;

import java.util.ArrayList;
import java.util.List;

import com.rokey.datastrcture.stack.Stack;

/**
 * 汉若塔问题
 * @author chenyuejun
 * @date 2018-10-23 8:50 PM
 **/
public class Tower<T extends Comparable<T>> {


	private Stack<T> stack;

	private String name;

	public Tower(String name) {
		this.name = name;
		this.stack = new Stack<>();
	}

	public String getName() {
		return name;
	}

	/**
	 * 放入该塔
	 * @param t
	 */
	public void addItem(T t) {

		if (!stack.isEmpty() && stack.peek().compareTo(t) <= 0) {
			System.out.println("t的值比塔最顶的值"+ stack.peek() + "大，无法放入" + t);
		} else {

			stack.push(t);
		}
	}

	/**
	 * 将塔顶元素 移到其它塔上
	 * @param otherTower
	 */
	public void moveTopToOtherTower(Tower otherTower) {

		T item = this.stack.peek();
		if (item == null) {
			System.out.println("当前塔上已无元素");
		} else {
			if (otherTower.getStack().peek() == null || item.compareTo((T) otherTower.getStack().peek()) < 0) {
				T pop = this.stack.pop();
				otherTower.addItem(pop);
				System.out.println("将盘子" + pop + "从塔" + this.getName() + "移动到塔" + otherTower.getName());
			}
		}
	}

	/**
	 * 将n个元素通过缓冲塔 移到目标塔上
	 * @param n
	 * @param destination
	 * @param buffer
	 */
	public void moveItemsToOtherTower(Integer n, Tower destination, Tower buffer) {

		if (n > 0) {

			moveItemsToOtherTower(n-1, buffer, destination);
			moveTopToOtherTower(destination);
			buffer.moveItemsToOtherTower(n-1, destination, this);
		}
	}

	public Stack<T> getStack() {
		return stack;
	}

	public static void main(String[] args) {

		List<Tower<Integer>> towerList = new ArrayList<>();
		towerList.add(new Tower<>("A"));
		towerList.add(new Tower<>("B"));
		towerList.add(new Tower<>("C"));
		for (int i = 10; i >0; i--) {
			towerList.get(0).addItem(i);
		}
		towerList.get(0).moveItemsToOtherTower(10, towerList.get(1), towerList.get(2));
		while (!towerList.get(1).getStack().isEmpty()) {
			Integer pop = towerList.get(1).getStack().pop();
			if (pop == null) {
				break;
			}
			System.out.println(pop);
		}
 	}
}