package com.rokey.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TestEmptyListForEach
 *
 * @author rokey
 * @create 2017-11-21 上午9:30
 **/
public class LambdaListTest {


	public static void main(String[] args) {

		ArrayList<String> emtpyList = new ArrayList<>();
		emtpyList.stream().forEach(str -> str = str + "1");

		List<String> collect = Stream.of("a", "b", "c").collect(Collectors.toList());
		for (String s : collect) {

			System.out.println(s);
		}
	}



}
