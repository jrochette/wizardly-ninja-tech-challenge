package io.ninja.jrochette.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.ninja.jrochette.core.utils.NinjaFinderArrayUtils;
import io.ninja.jrochette.core.utils.NinjaFinderStringUtils;

public class NinjaFinderService {
	/*
	 * Unique Values
	 * 
	 * Problem : Complete the isContainingOnlyUniqueValues method and return true if
	 * all the input values are distinct.
	 * 
	 * Input : An array of N items.
	 * 
	 * Output : true if all the input values are distinct or if the array is empty
	 * or if the array is null. False otherwise.
	 * 
	 * Example 1 : [1] returns true.
	 * 
	 * Example 2 : [1, 3, 1] returns false.
     */
	public boolean isContainingOnlyUniqueValues(int[] values) {
		if (values == null || values.length == 0) {
			return true;
		}

		Set<Integer> distinctValues = new HashSet<>();
		for (int value : values) {
			if (!distinctValues.add(value)) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Permutations
	 * 
	 * Problem : Complete the permutations method, generating all the possible
	 * permutations from a set of integers provided as a String. For instance, given
	 * the String "1 3", the method should return "1 3" and "3 1" as a list of
	 * strings.
	 * 
	 * Input : A string of positive integers. The integers in the input strings will
	 * be separated by one or more spaces. The input may contain duplicate elements.
	 * 
	 * Output : An instance of java.util.List<String>, containing a distinct set of
	 * permutations. Each integer should be separated by a single space. The Strings
	 * should be trimmed.
	 * 
	 * Example : "1 3" will return ["1 3", "3 1"].
	 * 
	 */
	public List<String> getPermutations(String value) {
		if (value == null || value.isEmpty()) {
			return new ArrayList<>();
		}

		int[] integers = NinjaFinderStringUtils.convertStringToArrayOfInteger(value);

		if (integers.length == 0) {
			return new ArrayList<>();
		}

		Set<String> permutations = new HashSet<String>();
		computePermutations(0, integers, permutations);

		return new ArrayList<>(permutations);
	}

	private void computePermutations(int start, int[] input, Set<String> permutations) {
		if (start == input.length) {
			permutations.add(NinjaFinderStringUtils.convertArrayOfIntegersToFormattedString(input));
			return;
		}
		for (int i = start; i < input.length; i++) {
			swapValuesAtIndexes(input, start, i);

			computePermutations(start + 1, input, permutations);

			swapValuesAtIndexes(input, start, i);
		}
	}

	private void swapValuesAtIndexes(int[] input, int firstIndex, int secondIndex) {
		int temp = input[secondIndex];
		input[secondIndex] = input[firstIndex];
		input[firstIndex] = temp;
	}
	
	/*
	 * Reverse
	 * 
	 * Problem : Complete the reverse method and return the provided integers in
	 * reverse order.
	 * 
	 * Input : A string of positive integers. The integers in the input string will
	 * be separated by one or more spaces. The input may contain duplicate elements.
	 * 
	 * Output : The reverse version of the input string. Each integer should be
	 * separated by a single space. The string should be trimmed.
	 * 
	 * Example : "1   2 3  " should return "3 2 1"
	 */
	public String reverse(String value) {
		if (value == null || value.isEmpty()) {
			return "";
		}

		List<Integer> reversedValue = NinjaFinderArrayUtils
				.convertArrayOfIntegersToList(NinjaFinderStringUtils.convertStringToArrayOfInteger(value));

		if (reversedValue.isEmpty()) {
			return "";
		}

		Collections.reverse(reversedValue);

		return NinjaFinderStringUtils.convertListOfIntegersToFormattedString(reversedValue);
	}
	
	/*
	 * Prime Palindrome
	 * 
	 * Problem : Complete the method primePalindrome to find the biggest prime
	 * number, which is also a palindrome, within the range of 1 - 1000. This being
	 * a constant, a good coder would just return the hard coded value. But, in the
	 * spirit of this test, please provide a complete solution to programmatically
	 * find the answer.
	 * 
	 * Input : none.
	 * 
	 * Output : An integer that meets the problem statement.
	 * 
	 * Example : No example.
	 */
	public int findBiggestPrimePalindromeInRange(int inferiorLimit, int upperLimit) {
		if(upperLimit < inferiorLimit) {
			return -1;
		}
		
		for (int i = upperLimit; i >= inferiorLimit; i--) {
			if (isPrime(i) && isPalindrome(i)) {
				return i;
			}
		}
		return -1;
	}

	private boolean isPrime(int number) {
		for (int i = 2; 2 * i < number; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	private boolean isPalindrome(int number) {
		return number == reverse(number);
	}

	private int reverse(int number) {
		int reverse = 0;
		while (number > 0) {
			int reminder = number % 10;
			reverse = reverse * 10 + reminder;
			number = number / 10;
		}
		return reverse;
	}
}
