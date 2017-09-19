package io.ninja.jrochette.core.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.collect.Lists;

public class NinjaFinderStringUtilsTest {

	@Test
	public void testConvertStringToArrayOfInteger() throws Exception {
		int[] integers = NinjaFinderStringUtils.convertStringToArrayOfInteger("1 2 3");
		assertEquals(3, integers.length);
		assertEquals(1, integers[0]);
		assertEquals(2, integers[1]);
		assertEquals(3, integers[2]);
	}

	@Test
	public void testConvertStringToArrayOfIntegerHandlesSpaces() throws Exception {
		int[] integers = NinjaFinderStringUtils.convertStringToArrayOfInteger("1    2     3");
		assertEquals(3, integers.length);
		assertEquals(1, integers[0]);
		assertEquals(2, integers[1]);
		assertEquals(3, integers[2]);
	}

	@Test
	public void testConvertArrayOfIntegersToFormattedString() throws Exception {
		assertEquals("1 2 3", NinjaFinderStringUtils.convertArrayOfIntegersToFormattedString(new int[] { 1, 2, 3 }));
	}

	@Test
	public void testConvertListOfIntegersToFormattedString() throws Exception {
		assertEquals(
				"1 2 3",
				NinjaFinderStringUtils.convertListOfIntegersToFormattedString(Lists.newArrayList(1, 2, 3)));
	}

}
