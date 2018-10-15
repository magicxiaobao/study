package com.rokey.java8.newdate;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.Chronology;
import java.time.chrono.HijrahChronology;
import java.time.format.DateTimeFormatter;

/**
 * Java8新的实践操作api
 * @author chenyuejun
 * @date 2018-03-12 上午9:58
 **/
public class NewDateApiInJava8 {

	public static void main(String[] args) {

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate now = LocalDate.now();
		System.out.println(now.format(dateTimeFormatter));

		LocalDateTime now1 = LocalDateTime.now();
		LocalDateTime yesterday = now1.minusDays(1);
		System.out.println(yesterday.format(dateTimeFormatter));

		LocalDate lastDayOfFebruary = LocalDate.of(2014, 2, 28);
		System.out.println(lastDayOfFebruary);

		LocalDate now2 = LocalDate.now(ZoneId.of("America/Phoenix"));
		System.out.println(now2);

		LocalDate hundredDay = LocalDate.ofYearDay(1988, 100);
		System.out.println(hundredDay);

		LocalTime now3 = LocalTime.now();
		System.out.println(now3);

		LocalTime time1 = LocalTime.of(1, 1, 2);
		System.out.println(time1);

		LocalTime time2 = LocalTime.ofSecondOfDay(10000);
		System.out.println(time2);

		LocalDateTime dateTime1 = LocalDateTime.now();
		System.out.println(dateTime1);

		LocalDateTime customDateTime = LocalDateTime.of(hundredDay, time1);
		System.out.println(customDateTime);

		LocalDateTime myBirthday = LocalDateTime.of(1988, 3, 3, 8, 8, 8);
		System.out.println(myBirthday);

		Instant timestamp = Instant.now();
		System.out.println(timestamp.toEpochMilli());

		Instant instant1 = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println(instant1.toEpochMilli());

		Duration duration = Duration.ofDays(20);
		System.out.println(duration.toDays());

		Chronology chronology = HijrahChronology.INSTANCE;
		ChronoLocalDateTime<? extends ChronoLocalDate> chronoLocalDateTime =
			chronology.localDateTime(LocalDateTime.now());
		System.out.println(chronoLocalDateTime);

	}

}