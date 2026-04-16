package eulerProject1To30;

import java.math.BigInteger;

public class Problem29 {
	public static BigInteger exponent(int x, int y) {
		if (y == 0) {
			return BigInteger.ONE;
		} else {
			return BigInteger.valueOf(x).multiply(exponent(x, y - 1));
		}
	}
	
	public static void main(String[] args) {
		String distinctPowers = " ";
		long numberOfDistinctPowers = 0;
		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				BigInteger exponentResult = exponent(i, j);
				if (!(distinctPowers.contains(" " + exponentResult + " "))) {
					distinctPowers += exponentResult + " ";
					numberOfDistinctPowers++;
				}
			}
		}
		System.out.println("Ausgabe: " + numberOfDistinctPowers);
		
		/* Remark: Almost crashed Java
		 * Problem solved
		 * 113799th person to have solved this problem
		 * Difficulty rating: 5% 
		 * */
	}
}
