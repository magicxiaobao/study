package com.rokey.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenyuejun
 * @date 2018-05-28 下午8:03
 **/
public class DateFormatTest {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		Date parsedDate = simpleDateFormat.parse("2018-1-2");
		System.out.println(simpleDateFormat2.format(parsedDate));

	}

}