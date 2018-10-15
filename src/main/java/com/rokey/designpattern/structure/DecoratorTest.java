package com.rokey.designpattern.structure;

import org.junit.Test;

/**
 * 装饰器模式
 * @author chenyuejun
 * @date 2018-03-15 上午11:30
 **/
public class DecoratorTest {


	@Test
	public void decorateTest() {

		DecoratorSource source = new DecoratorSource();
		Decorator decoratorTest = new Decorator(source);
		decoratorTest.method();
	}
}

class Decorator implements Sourceable {

	private DecoratorSource source;

	public Decorator(DecoratorSource source) {
		this.source = source;
	}

	@Override
	public void method() {

		System.out.println("before decorate");
		source.method();
		System.out.println("after decorate");
	}
}

interface Sourceable {

	void method();
}

class DecoratorSource implements Sourceable {

	@Override
	public void method() {

		System.out.println("source is happy");
	}
}
