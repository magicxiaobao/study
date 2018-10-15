package com.rokey.programexam;

import java.util.Scanner;

/**
 * 任何>=6的偶数都可以分解为两个质数之和，从键盘输入一个偶数，输出其分解的质 数
 *
 * @author chenyuejun
 * @date 2018-03-23 上午11:11
 **/
public class PrimTest {



	public static void main(String[] args) {

		int num = inPut();
		outPut(num);
	}

	public static int inPut() {
		//输入数字并通过检验确定一个符合要求的数
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入大于 6 的偶数:");
		int num = sc.nextInt();
		if (num % 2 != 0 || num <= 6) {

			System.out.println("输入错误，请重新输入大于 6 的偶数:");
			return inPut();//错误则返回 inPut()继续输入
			//正确则返回 num 值
		}
		return num;
	}

	public static boolean isPrim(int num){ //判断是否是质数
		for(int i=2;i<=Math.sqrt((double)num);i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}

	public static void outPut(int num) { //输出所有符合条件的质数对
		for (int i = 2; i <= num / 2; i++) {
			if (isPrim(i) == true && isPrim(num - i) == true) {
				System.out.println(i + " " + (num - i));
			}
		}
	}
}