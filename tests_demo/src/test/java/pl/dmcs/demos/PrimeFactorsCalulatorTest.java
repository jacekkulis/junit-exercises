package pl.dmcs.demos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrimeFactorsCalulatorTest {
	
	private static PrimeFactorsCalculator calculator;
	
	public PrimeFactorsCalulatorTest() {
		// TODO Auto-generated constructor stub
		System.out.println("PrimeFactorsCalulatorTest()");
	}
	
	@BeforeAll
	static void setup() {
		System.out.println("setup()");
		calculator = new PrimeFactorsCalculator();
	}
	
	@BeforeEach
	void init() {
		System.out.println("init()");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("tearDown()");
	}
	 
	@AfterAll
	static void done() {
		System.out.println("done()");
	}

	@Test
	void testPrimeFactorsCalculation() {
		System.out.println("testPrimeFactorsCalculation()");
		checkFactors(Collections.emptyList(), 1);
		checkFactors(Arrays.asList(2), 2);
		checkFactors(Arrays.asList(3), 3);
		checkFactors(Arrays.asList(2, 2), 4);
		checkFactors(Arrays.asList(5), 5);
		checkFactors(Arrays.asList(2, 3), 6);
		checkFactors(Arrays.asList(7), 7);
		checkFactors(Arrays.asList(2, 2, 2), 8);
		checkFactors(Arrays.asList(3, 3), 9);
		checkFactors(Arrays.asList(2, 5), 10);

		checkFactors(Arrays.asList(2, 2, 3, 7, 13, 13), 2 * 2 * 3 * 7 * 13 * 13);
	}

	private void checkFactors(List<Integer> expectedFactors, int n) {
		assertIterableEquals(expectedFactors, calculator.getFactors(n));
	}
}
