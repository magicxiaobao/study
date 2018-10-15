package com.rokey.designpattern.structure;

import org.junit.Test;

/**
 * 将被调用的接口转换为调用方期望的接口
 * 1.接口的适配 跟类的适配相似
 * 2.类的适配
 * 3.对象的适配
 * @author chenyuejun
 * @date 2018-03-15 上午10:41
 **/
public class AdaptorPatternTest {

	@Test
	public void testClassAdaptor() {

		Target classAdaptor = new ClassAdaptor();
		classAdaptor.method1();
		classAdaptor.method2();
	}

	@Test
	public void testObjectAdaptor() {

		ObjectAdaptor objectAdaptor = new ObjectAdaptor(new Source());
		objectAdaptor.method1();
		objectAdaptor.method2();
	}

	@Test
	public void testInterfaceAdaptor() {

		Target interfaceAdaptor = new InterfaceAdaptor();
		interfaceAdaptor.method1();
		interfaceAdaptor.method2();
	}
}

class ObjectAdaptor implements Target {

	private Source source;

	public ObjectAdaptor(Source source) {
		this.source = source;
	}

	@Override
	public void method1() {

		source.method1();
	}

	@Override
	public void method2() {

		System.out.println("objectAdaptor invoke method2");
	}
}

class ClassAdaptor extends Source implements Target {

	@Override
	public void method2() {

		System.out.println("adaptor invoke method2");
	}
}

class InterfaceAdaptor extends AbstractSource implements Target {

	@Override
	public void method1() {

		System.out.println("interface Adaptor invoke method1");
	}

	@Override
	public void method2() {

		System.out.println("interface Adaptor invoke method2");
	}
}

class Source {

	public void method1() {

		System.out.println("source method1 is invoked");
	}
}

interface SourceInterface {

	void method1();

	//该方法不在目标接口里
	void method3();
}

abstract class AbstractSource implements SourceInterface {

	@Override
	public abstract void method1();

	//空实现,
	@Override
	public void method3() {

	}
}

interface Target {

	void method1();

	void method2();
}