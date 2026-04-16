package eulerProject31To60;

import java.math.BigInteger;

public class Problem53 {
	public static BigInteger permutation(long input) {
		if (input <= 1) {
			return BigInteger.ONE;
		} else {
			return BigInteger.valueOf(input).multiply(permutation(input - 1));
		}
	}
	public static BigInteger combination(long input1, long input2) {
		return permutation(input1).divide(permutation(input2).multiply(permutation(input1 - input2)));
	}
	
	public static void main(String[] args) {
		long count = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = i - 1; j > 0; j--) {
				if (combination(i, j).compareTo(BigInteger.valueOf(1000000l)) > 0) {
					count++;
				}
			}
		}
		System.out.println("Ausgabe: " + count);
	}
	
	/*
	 * Problem solved
	 * 64051st person to have solved this problem
	 * Difficulty rating: 5%
	 * */
}
