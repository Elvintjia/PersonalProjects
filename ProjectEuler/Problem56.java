package eulerProject31To60;

import java.math.BigInteger;

public class Problem56 {
	public static BigInteger expt(BigInteger input, int eingabe) {
		if (eingabe == 1) {
			return input;
		} else {
			return input.multiply(expt(input, eingabe - 1));
		}
	}
	
	public static BigInteger digitalSum(String input) {
		if (input.length() == 1) {
			return new BigInteger(input);
		} else {
			return digitalSum(input.substring(1)).add(new BigInteger("" + input.charAt(0)));
		}
	}
	
	public static void main(String[] args) {
		BigInteger biggest = BigInteger.ZERO;
		for (BigInteger i = BigInteger.ONE; i.compareTo(new BigInteger("100")) < 0; i = i.add(BigInteger.ONE)) {
			for (int j = 1; j < 100; j++) {
				BigInteger comparator = digitalSum(expt(i, j) + "");
				if (biggest.compareTo(comparator) < 0) {
					biggest = comparator;
				}
			}
		}
		System.out.println("Ausgabe: " + biggest);
	}
	
	/*
	 * Problem solved
	 * 63340th person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
