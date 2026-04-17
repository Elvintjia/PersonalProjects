package eulerProject121to150;

import java.math.BigInteger;

public class Problem123 {
	public static boolean isPrime(BigInteger toCheck) {
		for (BigInteger i = BigInteger.TWO; i.multiply(i).compareTo(toCheck) <= 0; i = i.add(BigInteger.ONE)) {
			if (toCheck.mod(i).compareTo(BigInteger.ZERO) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static BigInteger primeSquareRemainders(int exponent) {
		BigInteger n = BigInteger.TWO;
		while (n.pow(2).compareTo(BigInteger.TEN.pow(exponent)) <= 0) {
			n = n.add(BigInteger.ONE);
		}
		System.out.println(n);
		while (!isPrime(n)) {
			n = n.add(BigInteger.ONE);
		}
		BigInteger toReturn = BigInteger.TEN.pow(exponent).divide(BigInteger.TWO).divide(n).add(BigInteger.ONE);
		return toReturn;
	}
	
	public static BigInteger primeSquareRemaindersTwo(int exponent) {
		BigInteger n = BigInteger.ONE;
		BigInteger p = BigInteger.TWO;
		while (true) {
			if (BigInteger.TWO.multiply(p).multiply(n).compareTo(BigInteger.TEN.pow(exponent)) > 0 &&
					n.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) != 0) {
				break;
			}
			n = n.add(BigInteger.ONE);
			p = p.add(BigInteger.ONE);
			while (!isPrime(p)) {
				p = p.add(BigInteger.ONE);
			}
		}
		// System.out.println(p);
		return n;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + primeSquareRemaindersTwo(10));
		/*
		BigInteger p = new BigInteger("237733");
		int n = 21034;
		System.out.println((p.add(BigInteger.ONE).pow(n).add(p.subtract(BigInteger.ONE).pow(n))).mod(p.pow(2)));
		*/
	}
	
	/*
	 * Problem solved
	 * 12954th person to have solved this problem
	 * Difficulty rating: 30%
	 * Runtime: 1 second
	 * */
}
