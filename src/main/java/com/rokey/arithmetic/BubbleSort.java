package com.rokey.arithmetic;

/**
 * 从小到大,就是先把最大的放到最后边
 * @author chenyuejun
 * @date 2018-03-22 上午9:25
 **/
public class BubbleSort {

	public static void main(String[] args) {

		int[] strs = {3, 4, 6, 10, 5, 2};

		for (int i = 1 ; i < strs.length; i++) {

			for (int j = 0; j < strs.length - i; j++) {

				if (strs[j] < strs[j + 1]) {

					int temp = strs[j];
					strs[j] = strs[j + 1];
					strs[j+ 1] = temp;
				}
			}
		}
		for (int i : strs) {

			System.out.println(i);
		}
	}
}