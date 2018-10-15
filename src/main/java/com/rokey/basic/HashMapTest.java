package com.rokey.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyuejun
 * @date 2018-05-22 下午10:31
 **/
public class HashMapTest {


	public static void main(String[] args) {


		ArrayList<Map> mapList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {

			HashMap<String, String> stringStringHashMap1 = new HashMap<>();

			stringStringHashMap1.put(i + "", i + "sss");
			mapList.add(stringStringHashMap1);
		}

		mapList.forEach(map -> {

			map.entrySet().forEach(entry -> System.out.println(entry));
		});


	}


}