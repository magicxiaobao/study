package com.rokey.basic;

import java.util.Calendar;

/**
 * Calendar里的状态可变，设计的不好
 * @author chenyuejun
 * @date 2018-03-12 上午11:00
 **/
public class CalendarTest {

	public CalendarTest() {

		System.out.println("Constructor Method Of CalendarTest");
	}

	public static void main(String[] args) {

		Calendar birth = Calendar.getInstance();
		birth.set(1975, Calendar.MAY, 25);
		Calendar now = Calendar.getInstance();
		System.out.println(daysBetween(birth, now));
		System.out.println(daysBetween(birth, now));

	}

	public static long daysBetween(Calendar begin, Calendar end) {

		long daysBetween = 0;
		while (begin.before(end)) {

			begin.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween++;
		}
		return daysBetween;
	}

}