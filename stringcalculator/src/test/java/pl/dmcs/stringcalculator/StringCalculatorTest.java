package pl.dmcs.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import pl.dmcs.stringcalculator.exceptions.NegativeNumberException;
import pl.dmcs.stringcalculator.utils.StringCalculator;

class StringCalculatorTest {

	@Test
	void shouldReturnZeroOnEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	void shouldReturnNumberFromOneNumberString() {
		assertEquals(1, StringCalculator.add("1"));
		assertEquals(2, StringCalculator.add("2"));
	}

	@Test
	void shouldReturnSumOfTwoNumbersSeparatedByComma() {
		assertEquals(1 + 1, StringCalculator.add("1,1"));
		assertEquals(2 + 2, StringCalculator.add("2,2"));
		assertEquals(50 + 50, StringCalculator.add("50,50"));
	}

	@Test
	void shouldReturnSumOfMultipleNumbersSeparatedByComma() {
		assertEquals(1 + 1 + 1, StringCalculator.add("1,1,1"));
		assertEquals(1 + 2 + 2, StringCalculator.add("1,2,2"));
		assertEquals(1 + 2 + 2 + 5, StringCalculator.add("1,2,2,5"));
		assertEquals(111 + 222 + 333 + 444 + 555 + 666 + 777 + 888 + 999,
				StringCalculator.add("111,222,333,444,555,666,777,888,999"));
	}

	@Test
	void shouldAcceptNewLineAsSeparator() {
		assertEquals(1 + 1 + 3, StringCalculator.add("1,1\n3"));
		assertEquals(1 + 1 + 3, StringCalculator.add("1\n1\n3"));
	}

	@Test
	void shouldAcceptCustomSeparator() {
		assertEquals(1 + 2, StringCalculator.add("//;\n1;2"));
		assertEquals(1 + 2 + 3, StringCalculator.add("//;\n1;2;3"));
		assertEquals(1 + 2, StringCalculator.add("//+\n1+2"));
		assertEquals(1 + 2 + 3, StringCalculator.add("//#\n1#2#3"));
		assertEquals(100 + 200 + 300 + 400, StringCalculator.add("//@\n100@200@300@400"));
	}

	@Test
	void shouldRaiseExceptionWhenNegativeNumber() {
		try {
			StringCalculator.add("-1,1");
		} catch (NegativeNumberException ex) {
			assertEquals("Negatives not allowed.", ex.getMessage());
		}
	}

	@Test
	void shouldRaiseExceptionWithMessageWhenNegativeNumbers() {
		try {
			StringCalculator.add("-1,1,-2,3,-4");
		} catch (NegativeNumberException ex) {
			System.out.println(ex.getMessage());
			assertEquals("Negatives not allowed: -1,-2,-4", ex.getMessage());
		}
	}

	@Test
	void shouldIgnoreNumbersBiggerThan1000() {
		assertEquals(2, StringCalculator.add("2,1001"));
		assertEquals(7, StringCalculator.add("5,1025225,2"));
		assertEquals(1, StringCalculator.add("1,1025225,225252525"));
	}

	@Test
	void shouldAcceptDelimitersWithAnyLenght() {
		assertEquals(1 + 2 + 3, StringCalculator.add("//[***]\n1***2***3"));
		assertEquals(1 + 2 + 3, StringCalculator.add("//[###]\n1###2###3"));
		assertEquals(4 + 6 + 3, StringCalculator.add("//[###]\n4###6###3"));
	}
}
