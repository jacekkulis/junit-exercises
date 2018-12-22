package pl.dmcs.stringcalculator.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import pl.dmcs.stringcalculator.exceptions.NegativeNumberException;

public class StringCalculator {
	private static String separator = ",|\n";

	public static int add(String s) {
		if (s.isEmpty()) {
			return 0;
		} else {
			if (s.startsWith("//[") && StringUtils.countMatches(s, "[") == 1) {
				separator += "|" + Pattern.quote(StringUtils.substringBetween(s, "[", "]"));
				s = s.substring(s.indexOf("]") + 2, s.length());
			} else if (s.startsWith("//[") && StringUtils.countMatches(s, "[") > 1) {
				// "//[#][@]\n1@2#3"
				System.out.println(StringUtils.countMatches(s, "["));
				int n = StringUtils.countMatches(s, "[");

				for (int i = 0; i < n; i++) {
					System.out.println(s);
					System.out.println(StringUtils.substringBetween(s, "[", "]"));
					s = s.substring(s.indexOf("]"), s.length());
				}

				separator += "|" + Pattern.quote(StringUtils.substringBetween(s, "[", "]"));

			} else if (s.startsWith("//")) {
				separator += "|\\" + String.valueOf(s.charAt(2));
				s = s.substring(4, s.length());
			}
			List<Integer> numbers = Arrays.stream(s.split(separator)).mapToInt(Integer::parseInt).boxed()
					.collect(Collectors.toList());
			checkNegativeNumbers(numbers);
			numbers = numbers.stream().filter(i -> i <= 1000).collect(Collectors.toList());
			return numbers.stream().mapToInt(Integer::intValue).sum();
		}
	}

	private static void checkNegativeNumbers(List<Integer> numbers) throws NegativeNumberException {
		List<Integer> negatives = numbers.stream().filter(i -> i < 0).collect(Collectors.toList());
		if (negatives.size() == 1) {
			throw new NegativeNumberException("Negatives not allowed.");
		} else if (negatives.size() > 1) {
			throw new NegativeNumberException("Negatives not allowed: "
					+ negatives.stream().map(String::valueOf).collect(Collectors.joining(",")));
		}
	}

}
