package com.rokey.datastrcture.clone;

import org.junit.Assert;
import org.junit.Test;



public class PersonTest {

	//Field number of type int[] - was not mocked since Mockito doesn't mock arrays
	Person person = new Person("name", 0, new int[] {0});

	@Test
	public void testGetNumber() throws Exception {
		int[] result = person.getNumber();
		Assert.assertArrayEquals(new int[] {0}, result);
	}

	@Test
	public void testClone() throws Exception {
		Object result = person.clone();
		Assert.assertNotEquals(null, result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme