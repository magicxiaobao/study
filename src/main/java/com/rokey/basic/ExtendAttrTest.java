package com.rokey.basic;

/**
 * @author chenyuejun
 * @date 2018-03-09 下午12:44
 **/
public class ExtendAttrTest extends B implements A{

	public static void main(String[] args) {

		ExtendAttrTest extendAttrTest = new ExtendAttrTest();
		System.out.println(extendAttrTest.fatherPrint());
		System.out.println(extendAttrTest.interfacePrint());

	}

	public String fatherPrint() {

		return super.x + "";
	}

	public String interfacePrint() {

		return A.x + "";
	}
}


interface A {

	int x = 0;
}

class B {

	int x = 1;
}