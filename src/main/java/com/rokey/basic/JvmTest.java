package com.rokey.basic;

/**
 * @author chenyuejun
 * @date 2018-03-09 下午12:19
 **/
public class JvmTest {


	public static void main(String[] args) {

		//虚拟机最大可用内存
		System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
		//虚拟机当前使用内存
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);

	}
}