package io.ninja.jrochette.core.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.collect.Lists;

public class NinjaFinderArrayUtilsTest {
	@Test
	public void testConvertArrayOfIntegersToList() throws Exception {
		assertEquals(
				Lists.newArrayList(1, 2, 3),
				NinjaFinderArrayUtils.convertArrayOfIntegersToList(new int[] { 1, 2, 3 }));
	}
}
