package com.rokey.basic;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * ClassLoader基础
 *
 * @author chenyuejun
 * @date 2018-03-08 下午3:49
 **/
public class ClassLoaderTest {


	public static void main(String[] args) {

		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

		System.out.println(System.getProperty("java.class.path"));
		try {

			Class child = Class.forName("com.rokey.basic.Child");
			System.out.println(child.getClassLoader());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		URL[] urLs = ((URLClassLoader) ClassLoader.getSystemClassLoader().getParent()).getURLs();
		for (URL url : urLs) {

			System.out.println(url.toString());
		}

	}

}