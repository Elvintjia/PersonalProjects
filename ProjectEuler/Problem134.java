package eulerProject121to150;

import java.util.ArrayList;
import java.math.BigInteger;

public class Problem134 {
	public static long searchN(int n, int o) {
		long p = 10;
		while (p < n) {
			p *= 10;
		}
		long q = 1;
		while (n > 0) {
			long temp = p * q + n;
			if (temp % o == 0) {
				return temp;
			}
			q++;
		}
		return 0;
	}
	
	public static ArrayList<Integer> erasthothenesSieve(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = i;
		}
		array[1] = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] != 0) {
				for (int j = i * 2; j < n; j += i) {
					array[j] = 0;
				}
			}
		}
		// System.out.println("Check");
		ArrayList<Integer> toReturn = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (array[i] > 0) {
				toReturn.add(array[i]);
			}
		}
		return toReturn;
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static BigInteger primePairConnection(int n) {
		ArrayList<Integer> sieve = erasthothenesSieve(n);
		while (n > 0) {
			if (isPrime(n)) {
				sieve.add(n);
				break;
			} else {
				n++;
			}
		}
		sieve.removeFirst();
		sieve.removeFirst();
		BigInteger toReturn = BigInteger.ZERO;
		while (sieve.size() > 1) {
			int temp = sieve.removeFirst();
			// System.out.println(temp);
			int temp2 = sieve.getFirst();
			toReturn = toReturn.add(new BigInteger("" + searchN(temp, temp2)));
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + primePairConnection(1000000));
	}
	
	/*
	 * Problem solved
	 * 8120th person to have solved this problem
	 * Problem level: 11
	 * Runtime: 1 minutes and 4 seconds
	 * */
}
