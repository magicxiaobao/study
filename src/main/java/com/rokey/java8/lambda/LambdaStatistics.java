package com.rokey.java8.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 统计相关 可以统计 Int long Double
 * @author chenyuejun
 * @date 2018-03-16 下午1:10
 **/
public class LambdaStatistics {


	public static void main(String[] args) {

		List<Integer> integers = Arrays.asList(1, 2, 6, 8, 3);
		IntSummaryStatistics intSummaryStatistics = integers.stream().mapToInt(i -> i).summaryStatistics();
		System.out.println(intSummaryStatistics.getMax());
		System.out.println(intSummaryStatistics.getMin());
		System.out.println(intSummaryStatistics.getAverage());
		System.out.println(intSummaryStatistics.getCount());
		System.out.println(intSummaryStatistics.getSum());

	}

}