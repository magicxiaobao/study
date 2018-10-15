package com.rokey.java8.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Java8 Optional 用来优雅的处理NullPointException的方法，避免手动写代码判断是否是null
 * 参考 http://www.importnew.com/22060.html
 * @author rokey
 * @create 2017-12-05 下午8:01
 **/
public class OptionalTest {


	@Test
	public void optionalOfTest() {

		String strExpected = "aaa";
		Optional<String> aaaOptional = Optional.of("aaa");
		Assert.assertEquals(strExpected, aaaOptional.get());
	}

	@Test(expected = NullPointerException.class)
	public void optionalOfNullTest() {

		Optional<Object> nullOptional = Optional.of(null);
	}

	@Test(expected = NoSuchElementException.class)
	public void optionalOfNullableTest() {

		Optional<Object> nullOptional = Optional.ofNullable(null);
		nullOptional.get();
	}

	@Test
	public void optionalEmptyTest() {

		Assert.assertEquals(Optional.empty(), Optional.ofNullable(null));
	}

	@Test
	public void optionalIsPresentTest_IfEmptyOptional_thenReturnNull() {

		Optional<Object> empty = Optional.empty();
		Assert.assertFalse(empty.isPresent());
	}

	@Test
	public void optionalIsPresentTest_IfNotEmpty_thenNotReturnNull() {

		Optional<String> aaaa = Optional.of("aaaa");
		Assert.assertTrue(StringUtils.isNotBlank(aaaa.get()));
	}

	@Test
	public void optionalIfPresentConsumerTest() {

		Optional.of("bb").ifPresent(value -> System.out.println(value.length()));
		Optional.empty().ifPresent(value -> System.out.println(value.toString()));
	}

	@Test
	public void optionalOrElseTest() {

		String optionalOrElseNotUsed = Optional.of("cc").orElse("orElse");
		Object orElseUsed = Optional.empty().orElse("orElseUsed");
		Assert.assertEquals("cc", optionalOrElseNotUsed);
		Assert.assertEquals("orElseUsed", orElseUsed.toString());
	}

	@Test
	public void optionalOrElseGetTest() {

		System.out.println(Optional.empty().orElseGet(() -> "ccccc"));
	}

	@Test
	public void optionalOrElseThrowTest() {

		try {
			Optional.empty().orElseThrow(OptionalException :: new);
		} catch (OptionalException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	public void optionalMapTest() {

		Optional<String> aaToUpcase = Optional.of("aaa").map(value -> value.toUpperCase());
		System.out.println(aaToUpcase.orElse("No value found"));
	}

	@Test
	public void optionalFlatMapTest() {

		Optional upName = Optional.of("aa").flatMap(value -> Optional.of(value.toUpperCase()));
		System.out.println(upName.orElse("No value found"));
	}

	@Test
	public void optionalFilterTest() {

		Optional<String> strLengthDown6 = Optional.of("aaa").filter(value -> value.length() > 6);
		Optional<String> strLengthUp6 = Optional.of("aaaaaaaaaa").filter(value -> value.length() > 6);
		Assert.assertTrue(strLengthDown6.isPresent() == false);
		Assert.assertTrue(strLengthUp6.isPresent());
	}


	class OptionalException extends Throwable {

		public OptionalException() {
		}

		public OptionalException(String message) {
			super(message);
		}

		@Override
		public String getMessage() {

			return "no value present in this optional instance";
		}
	}
}
