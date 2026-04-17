package eulerProject91to120;

import java.math.BigInteger;

public class Problem112 {
	public static boolean isBouncy(BigInteger number) {
		String numberString = number + "";
		boolean ascend = false;
		boolean descend = false;
		for (int i = 0; i < numberString.length() - 1; i++) {
			if (numberString.charAt(i) < numberString.charAt(i + 1)) {
				ascend = true;
			} else if (numberString.charAt(i) > numberString.charAt(i + 1)) {
				descend = true;
			}
			if (ascend && descend) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		BigInteger bouncyNumbers = BigInteger.ZERO;
		BigInteger notBouncyNumbers = BigInteger.ZERO;
		BigInteger i = BigInteger.ONE;
		for (; bouncyNumbers.compareTo(notBouncyNumbers.multiply(new BigInteger("99"))) != 0 ||
				bouncyNumbers.compareTo(BigInteger.ZERO) == 0 || notBouncyNumbers.compareTo(BigInteger.ZERO) == 0
				; i = i.add(BigInteger.ONE)) {
			// System.out.println(i);
			if (isBouncy(i)) {
				bouncyNumbers = bouncyNumbers.add(BigInteger.ONE);
			} else {
				notBouncyNumbers = notBouncyNumbers.add(BigInteger.ONE);
			}
		}
		System.out.println("Ausgabe: " + i.subtract(BigInteger.ONE));
	}
	
	/*
	 * Problem solved
	 * 27286th person to have solved this problem
	 * Difficulty rating: 15%
	 * Runtime: Less than 1 second
	 * */
}
