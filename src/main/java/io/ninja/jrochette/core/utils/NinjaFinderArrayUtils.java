package io.ninja.jrochette.core.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NinjaFinderArrayUtils {
	private NinjaFinderArrayUtils() {}
	
	public static List<Integer> convertArrayOfIntegersToList(int[] integers) {
		return IntStream.of(integers).boxed().collect(Collectors.toList());
	}
}
