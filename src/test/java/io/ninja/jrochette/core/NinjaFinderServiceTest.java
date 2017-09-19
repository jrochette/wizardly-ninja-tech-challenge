package io.ninja.jrochette.core;

import java.util.List;

import junit.framework.TestCase;

public class NinjaFinderServiceTest extends TestCase {
	private NinjaFinderService ninjaFinderService;

	protected void setUp() throws Exception {
		super.setUp();
		ninjaFinderService = new NinjaFinderService();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIsContainingOnlyUniqueValuesShouldReturnTrueWhenInputIsNull() {
		assertTrue(ninjaFinderService.isContainingOnlyUniqueValues(null));
	}

	public void testIsContainingOnlyUniqueValuesShouldReturnTrueWhenInputIsEmpty() {
		assertTrue(ninjaFinderService.isContainingOnlyUniqueValues(new int[] {}));
	}

	public void testIsContainingOnlyUniqueValueShouldReturnTrueWhenInputAsOneElement() {
		assertTrue(ninjaFinderService.isContainingOnlyUniqueValues(new int[] { 1 }));
	}

	public void testUniqueTwoSame() {
		assertFalse(ninjaFinderService.isContainingOnlyUniqueValues(new int[] { 1, 1 }));
	}

	public void testUniqueTwoDifferent() {
		assertTrue(ninjaFinderService.isContainingOnlyUniqueValues(new int[] { 1, 2 }));
	}

	public void testUniqueManyDifferent() {
		assertTrue(ninjaFinderService.isContainingOnlyUniqueValues(new int[] { 1, 2, 44, 58, 3, 10345 }));
	}

	public void testUniqueManyDuplicates() {
		assertFalse(ninjaFinderService.isContainingOnlyUniqueValues(new int[] { 1, 2, 44, 2, 3, 2 }));
	}

	public void testPermutationsShouldReturnEmptyListIfInputIsNull() {
		List<String> result = ninjaFinderService.getPermutations(null);
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testPermutationsShouldReturnEmptyListIfInputIsEmpty() {
		List<String> result = ninjaFinderService.getPermutations("");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testPermutationsShouldReturnEmptyListIfInputContainsOnlySpaces() {
		List<String> result = ninjaFinderService.getPermutations("      ");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testPermutationsShouldReturnEmptyListIfInputContainsCharacterThatIsNotAnInteger() {
		List<String> result = ninjaFinderService.getPermutations("  1  k ");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testPermutationsShouldReturnEmptyListIfInputIsNotAnInteger() {
		List<String> result = ninjaFinderService.getPermutations(" 4.567");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testPermutationValueOne() {
		List<String> result = ninjaFinderService.getPermutations("1");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertTrue(result.contains("1"));
	}

	public void testPermutationValueTwoDifferent() {
		List<String> result = ninjaFinderService.getPermutations("1 2");
		assertNotNull(result);
		assertEquals(2, result.size());
		assertTrue(result.contains("1 2"));
		assertTrue(result.contains("2 1"));
	}

	public void testPermutationValueThreeDifferent() {
		List<String> result = ninjaFinderService.getPermutations("1 2  3");
		assertNotNull(result);
		assertEquals(6, result.size());
		assertTrue(result.contains("1 2 3"));
		assertTrue(result.contains("1 3 2"));
		assertTrue(result.contains("2 3 1"));
		assertTrue(result.contains("2 1 3"));
		assertTrue(result.contains("3 2 1"));
		assertTrue(result.contains("3 1 2"));
	}

	public void testPermutationsOfThreeValuesWithTwoDuplicates() {
		List<String> result = ninjaFinderService.getPermutations("1 2  2");
		assertNotNull(result);
		assertEquals(3, result.size());
		assertTrue(result.contains("1 2 2"));
		assertTrue(result.contains("2 1 2"));
		assertTrue(result.contains("2 2 1"));
	}

	public void testReverseShouldReturnEmptyStringIfInputIsNull() {
		String result = ninjaFinderService.reverse(null);
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testReverseShouldReturnEmptyStringIfInputIsEmpty() {
		String result = ninjaFinderService.reverse("");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testReverseShouldReturnEmptyStringIfValueOnlyHasSpaces() {
		String result = ninjaFinderService.reverse("               ");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testReverseShouldReturnEmptyStringIfInputContainsLetters() {
		String result = ninjaFinderService.reverse("1 2 gg s");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testReverseShouldReturnEmptyStringIfDoesNotContainInteger() {
		String result = ninjaFinderService.reverse("3.14159265359");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testReverseSimple() {
		assertEquals("3 2 1", ninjaFinderService.reverse("1   2 3  "));
	}

	public void testReverseFourElements() {
		assertEquals("3 2 1 1", ninjaFinderService.reverse("1       1  2 3  "));
	}

	public void testReverseManyElementsNotSorted() {
		assertEquals("1 5 77 4 5 3 2 1 1", ninjaFinderService.reverse("1       1  2 3  5 4       77 5 1"));
	}
	
	public void testFindBiggestPrimePalindromeReturnsMinusOneIfLowerLimitIsHigherThanUpperLimitd() {
		assertTrue(ninjaFinderService.findBiggestPrimePalindromeInRange(10, 5) == -1);
	}

	public void testLargestPrimePalindromeIs929() {
		assertTrue(ninjaFinderService.findBiggestPrimePalindromeInRange(1, 1000) == 929);
	}

}
