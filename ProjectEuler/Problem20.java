package eulerProject1To30;

import java.math.BigInteger;

public class Problem20 {
	public static BigInteger factorial(int number) {
		BigInteger numbering = BigInteger.valueOf(number);
		if (number <= 1) {
			return BigInteger.ONE;
		} else {
			return numbering.multiply(factorial(number - 1));
		}
	}
	
	public static void main(String[] args) {
		String factorialResult = factorial(100) + " ";
		long sum = 0;
		for (int i = 0; i < factorialResult.length() - 1; i++) {
			sum += Long.valueOf(factorialResult.substring(i, i + 1));
		}
		System.out.println("Ausgabe: " + sum);
		
		/*
		 * Problem solved
		 * 211448th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
