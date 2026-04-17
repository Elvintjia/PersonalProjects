package eulerProject121to150;

import java.math.BigInteger;

public class Problem121 {
	public static BigInteger discGamePrizeFund(int rounds) {
		return factorial(rounds + 1).divide(iter(0, 0, rounds));
	}
	
	public static BigInteger iter(int redDisc, int blueDisc, int rounds) {
		// System.out.println(redDisc + " " + blueDisc);
		if (redDisc + blueDisc == rounds) {
			if (blueDisc >= redDisc) {
				// System.out.println(redDisc + " " + blueDisc);
				return BigInteger.ONE;
			} else {
				return BigInteger.ZERO;
			}
		} else {
			BigInteger toReturn = BigInteger.ZERO;
			toReturn = toReturn.add(iter(redDisc + 1, blueDisc, rounds));
			toReturn = toReturn.add(iter(redDisc, blueDisc + 1, rounds));
			return toReturn;
		}
	}
	
	public static BigInteger factorial(int term) {
		BigInteger toReturn = BigInteger.ONE;
		for (int i = term; i > 1; i--) {
			toReturn = toReturn.multiply(new BigInteger("" + i));
		}
		return toReturn;
	}
	
	public static BigInteger discGamePrizeFundTwo(int rounds) {
		return factorial(rounds + 1).divide(iterTwo(rounds, 0, 0));
	}
	
	public static BigInteger iterTwo(int round, int blueDisc, int redDisc) {
		if (round == 0) {
			if (blueDisc >= redDisc) {
				return BigInteger.ONE;
			} else {
				return BigInteger.ZERO;
			}
		} else {
			BigInteger toReturn = BigInteger.ZERO;
			toReturn = toReturn.add(iterTwo(round - 1, blueDisc + 1, redDisc));
			toReturn = toReturn.add((iterTwo(round - 1, blueDisc, redDisc + 1)).multiply(new BigInteger("" + round)));
			return toReturn;
		}
	}
	
	public static void main(String[] args) {
		// System.out.println(factorial(5));
		// System.out.println(iter(0, 0, 4));
		System.out.println("Ausgabe: " + discGamePrizeFundTwo(15));
	}
	
	/* Remark: The first function can solve the test case of 4 correctly, but not the intended question. The second
	 * function can't solve the test case of 4 correctly, but can solve the intended question. I don't fully understand
	 * the math behind it, but oh well.
	 * Problem solved
	 * 10967th person to have solved this problem
	 * Difficulty rating: 35%
	 * Runtime: 1 second
	 * */
}
