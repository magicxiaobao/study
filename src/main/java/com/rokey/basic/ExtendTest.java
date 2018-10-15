package com.rokey.basic;

import com.rokey.basic.Child;

/**
 * @author chenyuejun
 * @create 2017-11-15 下午4:18.
 */
public class ExtendTest {


	public static void main(String[] args) {

		Child child = new Child("xiaobao");
		child.sayHelloPublic("haha");

		String aa = "a-#b-#c-#d";
		System.out.println(aa.replaceAll("-", "_"));
		System.out.println(aa.replace("-", "_"));
//		child.sayHello("hahah");//provided 的方法只能在子类中或者同一个包下面被调用



	}

}
