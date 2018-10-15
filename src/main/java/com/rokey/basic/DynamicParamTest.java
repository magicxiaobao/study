package com.rokey.basic;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 动态参数方法测试
 *
 * @author rokey
 * @create 2017-12-11 下午6:32
 **/
public class DynamicParamTest {


	public void dynamicParam(String... strings) {

		if (ArrayUtils.isNotEmpty(strings)) {

			for (String str: strings) {

				System.out.println(str);
			}
		}
	}

	public static void main(String[] args) {

		DynamicParamTest dynamicParamTest = new DynamicParamTest();
		String[] strings = new String[] {"aaa", "bbb", "ccc"};
		dynamicParamTest.dynamicParam(strings);
	}

}
