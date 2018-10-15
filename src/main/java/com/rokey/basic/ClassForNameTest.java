package com.rokey.basic;

/**
 * @author chenyuejun
 * @date 2018-03-09 上午8:58
 **/
public class ClassForNameTest {


	public ClassForNameTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {

		Object o = loadClassAndReturnInstance("com.rokey.basic.StringTest");
		System.out.println(o.getClass().getClassLoader());
	}

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

		Class<?> aClass = Class.forName("com.rokey.basic.ClassForNameTest", false, new CustomClassLoader());
		Object classForNameTest = aClass.newInstance();

	}

	public Object loadClassAndReturnInstance(String name)
		throws ClassNotFoundException, IllegalAccessException, InstantiationException {

		Class<?> aClass = Class.forName(name);
		return aClass.newInstance();
	}


}