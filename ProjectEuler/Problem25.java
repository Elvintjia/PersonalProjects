package eulerProject1To30;

import java.math.BigInteger;

public class Problem25 {
	public static void main(String[] args) {
		long counter = 2;
		BigInteger firstNumber = BigInteger.ONE;
		BigInteger secondNumber = BigInteger.ONE;
		BigInteger sum = BigInteger.ZERO;
		
		while (sum.toString().length() < 1000) {
			counter++;
			sum = firstNumber.add(secondNumber);
			firstNumber = secondNumber;
			secondNumber = sum;
		}
		
		System.out.println("Ausgabe: " + counter);
		
		/*
		 * Problem solved
		 * 166625th person to have solved this problem
		 * Difficulty rating: 5%
		 * */
	}
}
