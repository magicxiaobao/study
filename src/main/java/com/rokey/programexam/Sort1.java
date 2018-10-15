package com.rokey.programexam;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * 用 1,2 , 2 ,3, 4 ,5 这 6 个数字, 用 Java 写一个 main 函数, 打印出所有不同的排列,
 * 如: 512234, 412345 等, 要求: “4”不能在第三位, “3”与”5”不能相连
 * @author chenyuejun
 * @date 2018-03-20 上午9:37
 **/
public class Sort1 {

	private String[] source = {"1", "2", "2", "3", "4", "5"};
	int n = source.length;
	boolean[] visited = new boolean[n];
	String result = "";
	TreeSet<String> set = new TreeSet<>();
	int [][] a = new int[n][n];

	private void searchMap() {

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				if (i == j) {

					a[i][j] = 0;
				} else {

					a[i][j] = 1;
				}
			}
		}
		//3和5不能相连
		a[3][5] = 0;
		a[5][3] = 0;
		//开始遍历
		for (int i = 0; i< n; i++) {

			search(i);
		}
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {

			String str = iterator.next();
			if (str.indexOf("4") != 2) {

				System.out.println(str);
			}
		}

	}

	private void search(int startIndex) {

		visited[startIndex] = true;
		result = result + source[startIndex];
		if (result.length() == n) {

			set.add(result);
		}
		for (int j = 0; j < n; j++) {

			if (a[startIndex][j] == 1 && visited[j] == false) {

				search(j);
			} else {

				continue;
			}
		}
		//一个 result 结束后踢掉最后一个，寻找别的可能性，若没有的话，则继续向前踢掉当前最后一个
		result = result.substring(0,result.length()-1);
		visited[startIndex] = false;
	}

	public static void main(String[] args) {

		new Sort1().searchMap();
	}
}