package eulerProject61to90;

import java.util.*;
import java.math.BigInteger;

public class Problem87 {
	public static boolean isPrime(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static BigInteger expt(int a, int b) {
		BigInteger temp = new BigInteger("" + a);
		if (b == 1) {
			return temp;
		} else {
			return temp.multiply(expt(a, b - 1));
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> primeArray = new ArrayList<Integer>();
		for (int i = 2; i * i < 50000000; i++) {
			if (isPrime(i)) {
				primeArray.add(i);
			}
		}
		// System.out.println(primeArray.getLast());
		ArrayList<BigInteger> taken = new ArrayList<BigInteger>();
		BigInteger limit = new BigInteger("50000000");
		for (int i = 0; i < primeArray.size(); i++) {
			BigInteger checked = expt(primeArray.get(i), 4);
			if (checked.compareTo(limit) == 1) {
				break;
			}
			for (int j = 0; j < primeArray.size(); j++) {
				BigInteger checked2 = checked.add(expt(primeArray.get(j), 3));
				if (checked2.compareTo(limit) == 1) {
					break;
				}
				for (int k = 0; k < primeArray.size(); k++) {
					// System.out.println(i + " " + j + " " + k);
					BigInteger checked3 = checked2.add(expt(primeArray.get(k), 2));
					// System.out.println(checked);
					if (checked3.compareTo(limit) <= 0) {
						// System.out.println(checked3 + " " + i + " " + j + " " + k);
						taken.add(checked3);
					} else {
						break;
					}
				}
				
			}
		}
		// System.out.println("Done");
		Set<BigInteger> set = new HashSet<>(taken);
		// System.out.println("divider");
		/*
		for (int i = 0; i < taken.size(); i++) {
			System.out.println(taken.get(i));
		}
		*/
		System.out.println("Ausgabe: " + set.size());
	}
	
	/* Remark: I had so much difficulties in this problem, not because I don't know the correct algorithm, but because
	 * I didn't know how to avoid duplicates, and any effort I know that reduces duplicates are too inefficient. I had to
	 * google a solution to remove duplicates efficiently.
	 * Problem solved
	 * 23244th person to have solved this problem
	 * Difficulty rating: 20%
	 * Runtime: Less than 1 second
	 * */
}
