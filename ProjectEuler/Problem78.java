package eulerProject61to90;

import java.math.BigInteger;

public class Problem78 {
	static BigInteger[] array = new BigInteger[1000000000];
	
	public static long coinPartitions(long input, long biggest) {
		if (input < 0) {
			return 0;
		} else if (input == 0) {
			return 1;
		} else {
			long sum = 0;
			for (int i = 1; i <= biggest; i++) {
				sum += coinPartitions(input - i, i);
			}
			return sum;
		}
	}
	
	public static long pentagonalNumbers(long k) {
		return k * (3 * k - 1) / 2;
	}
	
	public static BigInteger coinPartitionsTwo(long input) {
		BigInteger toReturn = BigInteger.ZERO;
		long n = 1;
		long p = pentagonalNumbers(n);
		long count = 0;
		while (input > p) {
			BigInteger t = array[(int) (input - p - 1)];
			// System.out.println(n + " " + p + " " + toReturn);
			if (count % 4 <= 1) {
				toReturn = toReturn.add(t);
			} else {
				toReturn = toReturn.subtract(t);
			}
			count++;
			n *= -1;
			if (n > 0) {
				n++;
			}
			p = pentagonalNumbers(n);
		}
		if (input == p) {
			if (count % 4 <= 1) {
				toReturn = toReturn.add(BigInteger.ONE);
			} else {
				toReturn = toReturn.subtract(BigInteger.ONE);
			}
		}
		toReturn = toReturn.mod(new BigInteger("1000000"));
		array[(int) input - 1] = toReturn;
		return toReturn;
	}
	
	public static void main(String[] args) {
		/*
		for (int i = 0; i < array.length; i++) {
			int iPlusOne = i + 1;
			array[i] = coinPartitions(iPlusOne, iPlusOne);
		}
		*/
		array[0] = BigInteger.ONE;
		long n = 2;
		BigInteger pn = coinPartitionsTwo(n);
		while (!pn.equals(BigInteger.ZERO)) {
			n++;
			pn = coinPartitionsTwo(n);
			// System.out.println(n + " " + pn);
		}
		System.out.println("Ausgabe: " + n);
		// 153 54770336324
	}
	
	/* Remark: This problem took longer than I hoped due to my lack of knowledge on an efficient method, plus the varying
	 * mistakes I made along the way during the programming part.
	 * Problem solved
	 * 19129th person to have solved this problem
	 * Difficulty rating: 30%
	 * Load time: 3 seconds
	 * */
}
