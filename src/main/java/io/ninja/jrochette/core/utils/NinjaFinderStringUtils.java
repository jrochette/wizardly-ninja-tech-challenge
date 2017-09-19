package io.ninja.jrochette.core.utils;

import java.util.Arrays;
import java.util.List;

public class NinjaFinderStringUtils {
	private NinjaFinderStringUtils() {}
	
	public static int[] convertStringToArrayOfInteger(String stringValue) {
		try {
			return Arrays.asList(stringValue.split(" ")).stream()
					.filter(string -> string != null && !string.isEmpty()).mapToInt(Integer::parseInt).toArray();
		} catch (NumberFormatException e) {
			return new int[] {};
		}
	}

	public static String convertArrayOfIntegersToFormattedString(int[] integers) {
		return convertListOfIntegersToFormattedString(NinjaFinderArrayUtils.convertArrayOfIntegersToList(integers));
	}

	public static String convertListOfIntegersToFormattedString(List<Integer> integers) {
		String formattedString = "";
		for (Integer integer : integers) {
			formattedString = formattedString + integer + " ";
		}
		return formattedString.trim();
	}
}
