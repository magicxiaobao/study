package com.rokey.designpattern.createtype.singleton;

/**
 * @author chenyuejun
 * @date 2018-03-15 上午10:18
 **/
public class InnerClassSingleton {


	public static Singleton getInstance() {

		return SingletonHolder.singleton;
	}

	private static class SingletonHolder {

		public  static Singleton singleton = new Singleton();
	}

	static class Singleton {

	}
}