package com.rokey.programexam;

/**
 *
 * 一个数如果恰好等于它的因子之和, 这个数就称为”完数”. 例如 6 = 1+2+3。编程找出 1000 以内的所有完数
 * @author chenyuejun
 * @date 2018-03-20 上午11:53
 **/
public class WanShu {

	public static void main(String[] args) {

		for (int i = 2; i < 1000; i++) {

			int sum = 0;
			for (int j = 1; j < i; j++) {

				if (i%j == 0) {

					sum +=j;
				}
			}
			if (sum == i) {

				System.out.print("完数: " + i + " 因数: ");
				for (int k = 1; k < i; k++) {

					if (i % k == 0) {

						System.out.print(k + " ");
					}
				}
				System.out.println(" ");
			}
		}


	}


}