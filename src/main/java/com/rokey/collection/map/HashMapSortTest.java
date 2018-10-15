package com.rokey.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author chenyuejun
 * @date 2018-03-12 下午1:48
 **/
public class HashMapSortTest {


	public static void main(String[] args) {

		HashMap<Integer, Person> map1 = new HashMap<>();
		map1.put(1, new Person("xiaobao", 2));
		map1.put(2, new Person("suisui", 3));
		map1.put(3, new Person("guoguo", 1));
		map1 = sort(map1);
		System.out.println(map1);
	}

	@Test
	public void testHashMapShouldBeOrderedButNotAlpha() {

		HashMap<String, Integer> unSortedMap = new HashMap<>();
		unSortedMap.put("z", 22);
		unSortedMap.put("g", 34);
		unSortedMap.put("c", 98);
		unSortedMap.put("d", 23);
		unSortedMap.put("a", 100);
		Assert.assertEquals("{a=100, c=98, d=23, g=34, z=22}", unSortedMap.toString());
	}

	@Test
	public void testHashMapSortByValueDesc() {

		HashMap<String, Integer> unSortedMap = new HashMap<>();
		unSortedMap.put("z", 22);
		unSortedMap.put("g", 34);
		unSortedMap.put("c", 98);
		unSortedMap.put("d", 23);
		unSortedMap.put("a", 100);
		LinkedHashMap<String, Integer> sortedMap = unSortedMap.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
			.collect(Collectors.toMap(
				Map.Entry :: getKey,
				Map.Entry :: getValue,
				(key1, key2) -> key2,
				LinkedHashMap::new
			));
		Assert.assertEquals("{a=100, c=98, g=34, d=23, z=22}", sortedMap.toString());
	}

	public static HashMap<Integer, Person> sort(HashMap<Integer, Person> hashMap) {

		return hashMap.entrySet().stream()
			.sorted((entry1, entry2) -> entry2.getValue().getAge() - entry1.getValue().getAge())
			.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(), (key1, key2) -> key2, LinkedHashMap::new));
	}

	static class Person {

		private String name;

		private Integer age;

		public Person(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
		}
	}

}