package com.rokey.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 泛型 本质是参数化类型
 * 参考 http://www.runoob.com/java/java-generics.html
 * @author chenyuejun
 * @date 2018-03-23 下午12:42
 **/
public class GenericTest {

	/**
	 * 没有放相同类型的数据，并没有报错，但是实际场景中一般都是在容器中保存同一类型的数据
	 */
	@Test
	public void withOutGenericTest() {

		List withOutGeneric = new ArrayList();
		withOutGeneric.add("a");
		withOutGeneric.add(3);
		for (Object o : withOutGeneric) {

			System.out.println(o);
		}
	}

	public <T> T methodWithGeneric(List<T> list) {

		for (T t : list) {

			System.out.printf("%s", t);
		}
		System.out.println("");
		return list.get(list.size() - 1);
	}

	@Test
	public void methodWithGenericTest() {

		List<Integer> integers1 = Arrays.asList(1, 3, 5, 2);
		List<String> strings = Arrays.asList("a", "b", "c", "D");
		Integer integer = methodWithGeneric(integers1);
		System.out.println(integer);
		String s = methodWithGeneric(strings);
		System.out.println(s);
	}

	public static void main(String[] args) {



	}

}