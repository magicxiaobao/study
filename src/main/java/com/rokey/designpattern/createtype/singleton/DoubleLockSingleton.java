package com.rokey.designpattern.createtype.singleton;

/**
 * 双重锁模式，这种实现方式不好
 * @author chenyuejun
 * @date 2018-03-15 上午10:03
 **/
public class DoubleLockSingleton {

	private static DoubleLockSingleton singleton;

	private DoubleLockSingleton () {

	}

	public DoubleLockSingleton getInstance () {

		if (singleton == null) {

			synchronized (DoubleLockSingleton.class) {

				if (singleton == null) {

					singleton = new DoubleLockSingleton();
				}
			}
		}
		return singleton;
	}
}