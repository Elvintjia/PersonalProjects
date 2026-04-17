package eulerProject121to150;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem125 {
	BigInteger next;
	BigInteger sum;
	
	public Problem125(BigInteger n) {
		sum = n.pow(2).add(n.add(BigInteger.ONE).pow(2));
		next = n.add(BigInteger.TWO);
	}
	
	public BigInteger makeBigger() {
		sum = sum.add(next.pow(2));
		next = next.add(BigInteger.ONE);
		return sum;
	}
	
	public String toString() {
		return sum + " " + next;
	}
	
	public static boolean isPalindromic(String input) {
		for (int i = 0; i < input.length() / 2; i ++) {
			if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static BigInteger palindromicSums(int limit) {
		BigInteger toReturn = BigInteger.ZERO;
		for (int i = 2; true; i++) {
			BigInteger sum = BigInteger.ZERO;
			for (int j = 1; j <= i; j++) {
				sum = sum.add((new BigInteger("" + j)).pow(2));
			}
			if (sum.compareTo(BigInteger.TEN.pow(limit)) >= 0) {
				break;
			}
			if (isPalindromic("" + sum)) {
				// System.out.println(sum);
				toReturn = toReturn.add(sum);
			}
			for (int j = 2; true; j++) {
				sum = BigInteger.ZERO;
				for (int k = j; k - j < i; k++) {
					sum = sum.add((new BigInteger("" + k)).pow(2));
				}
				if (sum.compareTo(BigInteger.TEN.pow(limit)) >= 0) {
					break;
				} else if (isPalindromic("" + sum)) {
					// System.out.println(sum);
					toReturn = toReturn.add(sum);
				}
			}
		}
		return toReturn;
	}
	
	public static BigInteger palindromicSumsTwo(int limit) {
		ArrayList<Problem125> array = new ArrayList<>();
		ArrayList<BigInteger> taken = new ArrayList<>();
		BigInteger sum = BigInteger.ZERO;
		BigInteger i = BigInteger.ONE;
		Problem125 temp = new Problem125(i);
		while (temp.sum.compareTo(BigInteger.TEN.pow(limit)) < 0) {
			array.add(temp);
			if (isPalindromic(temp.sum + "") && !taken.contains(temp.sum)) {
				// System.out.println(temp.sum);
				taken.add(temp.sum);
				sum = sum.add(temp.sum);
			}
			i = i.add(BigInteger.ONE);
			temp = new Problem125(i);
		}
		while (!array.isEmpty()) {
			BigInteger temp2 = array.getFirst().makeBigger();
			if (temp2.compareTo(BigInteger.TEN.pow(limit)) < 0) {
				if (isPalindromic(temp2 + "") && !taken.contains(temp2)) {
					// System.out.println(temp2);
					taken.add(temp2);
					sum = sum.add(temp2);
				}
			} else {
				array.removeFirst();
			}
		}
		/*
		for (int j = 0; j < array.size(); j++) {
			System.out.println(array.get(j));
		}
		*/
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + palindromicSumsTwo(8));
		// First method result: 2916867073
	}
	
	/* Remark: Implementing the algorithm was easy. What was hard was realizing a duplicate number can be produced.
	 * Problem solved
	 * 15204th person to have solved this problem.
	 * Difficulty rating: 25%
	 * Runtime: 1 second
	 * */
}
