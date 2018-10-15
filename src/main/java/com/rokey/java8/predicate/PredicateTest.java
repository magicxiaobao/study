package com.rokey.java8.predicate;

import java.util.function.Predicate;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author chenyuejun
 * @create 2018-01-06 上午11:07
 **/
public class PredicateTest {


	@Test
	public void predicateTest() {

		Predicate<String> predicate = String::isEmpty;
		assertTrue(predicate.test(""));
	}

	@Test
	public void predicateTestReturnFalse() {

		Predicate<String> predicate = s -> s.length() > 5;
		assertFalse(predicate.test("a"));
	}

}
