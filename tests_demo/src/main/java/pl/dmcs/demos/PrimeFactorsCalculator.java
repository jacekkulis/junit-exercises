package pl.dmcs.demos;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator {
	public List<Integer> getFactors(int n) {
		List<Integer> factors = new ArrayList<Integer>();
		
		int divider = 2;

		while (n > 1) {
			while (n % divider == 0) {
				factors.add(divider);
				n /= divider;
			}
			divider++;	
		}
		
		return factors;
	}
}
