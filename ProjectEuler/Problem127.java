package eulerProject121to150;

import java.util.ArrayList;
import java.math.BigInteger;

public class Problem127 {
	public static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}
	
	public static ArrayList<Integer> radicals(int a) {
		ArrayList<Integer> toReturn = new ArrayList<>();
		for (int i = 2; a > 1; i++) {
			if (a % i == 0) {
				toReturn.add(i);
				while (a % i == 0) {
					a /= i;
				}
			}
		}
		return toReturn;
	}
	
	public static int[] radicalsSieve(int limit) {
		int[] sieve = new int[limit];
		sieve[0] = 1;
		for (int i = 1; i < limit; i++) {
			if (sieve[i] == 0) {
				sieve[i] = i + 1;
				ArrayList<Integer> radical = radicals(i + 1);
				iter(sieve, radical, i + 1, i + 1, 0);
			}
		}
		return sieve;
	}
	
	public static void iter(int[] sieve, ArrayList<Integer> radicals, int num, int base, int index) {
		for (int i = index; i < radicals.size(); i++) {
			int temp = num * radicals.get(i);
			if (temp <= sieve.length && temp > 0) {
				sieve[temp - 1] = base;
				iter(sieve, radicals, temp, base, i);
			}
		}
	}
	
	public static BigInteger abcHits(int limit) {
		int[] sieve = radicalsSieve(limit);
		BigInteger toReturn = BigInteger.ZERO;
		for (int i = 1; i < limit; i++) {
			// System.out.println(i);
			for (int j = i + 1; i + j < limit; j++) {
				long temp = (long) sieve[i - 1] * sieve[j - 1] * sieve[i + j - 1];
				if (temp > 0 && temp < i + j && gcd(i, j) == 1) {
					toReturn = toReturn.add(new BigInteger("" + (i + j)));
					/*
					System.out.println(i + " " + j + " " + (i + j));
					System.out.println(sieve[i - 1] + " " + sieve[j - 1] + " " + sieve[i + j - 1]);
					System.out.println(temp + "\n");
					*/
				}
			}
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		// System.out.println(2l * 5 * 31 * 193 * 3 * 6679 * 277 * 433);
		System.out.println("Ausgabe: " + abcHits(120000));
	}
	
	/* Remark: This problem took me way too long to solve. A combination of stackoverflow and some unknown problem made
	 * all my solutions work with smaller numbers, but it wouldn't work with big ones. I really expended too much
	 * time and effort on this problem.
	 * Problem solved
	 * 7273rd person to have solved this problem
	 * Problem level: 13
	 * Runtime: 7 seconds
	 * */
}
