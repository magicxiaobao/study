package com.rokey.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 动态代理Demo,Jdk的代理，代理接口
 * @author chenyuejun
 * @date 2018-03-15 上午9:14
 **/
public class DynamicProxy {

	public static void main(String[] args) {

		ArrayList<String> strings = new ArrayList<>();
		Object proxyInstance = Proxy
			.newProxyInstance(strings.getClass().getClassLoader(), strings.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

						System.out.println("before invoke method " + method.getName() +" begin intercept");
						return method.invoke(strings, args);
					}
				});

		((List)proxyInstance).add("a");
		Object o = ((List) proxyInstance).get(0);
		System.out.println(o);
	}

	@Test
	public void testCglibProxy() {

		CglibProxy cglibProxy = new CglibProxy();
		Car instance = (Car)cglibProxy.getInstance(new Car());
		instance.run();
	}


}

class Car {

	public void run() {

		System.out.println("car is running");
	}
}

class CglibProxy implements MethodInterceptor {

	private Object car;

	/**
	 * 创建代理对象
	 *
	 */
	public Object getInstance(Object object) {
		this.car = object;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.car.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

		System.out.println("before invoke");
		methodProxy.invokeSuper(o, objects);
		System.out.println("after invoke");
		return null;
	}
}