package com.rokey.basic;

/**
 * @author chenyuejun
 * @create 2017-11-15 下午4:16.
 */
public class Father {


	private int age;

	public Father(int age) {

		this.age = age;
		System.out.println("Father Constructor With Age");
	}

	public Father() {

		System.out.println("Father Constructor No aggrument");
	}

	protected void sayHello(String str) {

		System.out.println("Father say Hello");
	}

	public void sayHelloPublic(String str) {

		System.out.println("Father say Hello Public");
	}


}
