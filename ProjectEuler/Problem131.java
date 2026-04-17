package eulerProject121to150;

import java.util.ArrayList;

public class Problem131 {
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
	
	public static int primeCubePartnership(int n) {
		int toReturn = 0;
		for (int i = 1; i < n; i++) {
			if (isPrime(i)) {
				for (int j = 1; j < n; j++) {
					long res = (long) j * j * j + (long) j * j * i;
					double cube = Math.cbrt(res);
					if (cube == (long) cube) {
						toReturn++;
						System.out.println(i + " " + j);
						break;
					}
				}
			}
		}
		return toReturn;
	}
	
	public static ArrayList<Integer> erasthothenesSieve(int limit) {
		int[] array = new int[limit];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		array[1] = 0;
		ArrayList<Integer> toReturn = new ArrayList<>();
		for (int i = 2; i < array.length; i++) {
			if (array[i] != 0) {
				toReturn.add(array[i]);
				for (int j = i; j < array.length; j += i) {
					array[j] = 0;
				}
			}
		}
		return toReturn;
	}
	
	public static boolean check(long p, long n) {
		n = n * n * n;
		double res = n * n * n + n * n * p;
		// System.out.println(res);
		res = Math.cbrt(res);
		// System.out.println(res);
		return (res == (long) res);
	}
	
	public static int primeCubePartnershipTwo(int limit) {
		ArrayList<Integer> sieve = erasthothenesSieve(limit);
		// System.out.println(sieve.getLast());
		int n = 1;
		int toReturn = 0;
		while (!sieve.isEmpty()) {
			int index = 0;
			while (!check(sieve.get(index), n)) {
				index++;
				if (index == sieve.size()) {
					break;
				}
			}
			if (index == sieve.size()) {
				sieve.removeFirst();
			} else {
				toReturn++;
				int marker = sieve.get(index);
				System.out.println(n + " " + marker);
				while (sieve.getFirst() != marker) {
					sieve.removeFirst();
				}
			}
			n++;
		}
		// System.out.println(n);
		return toReturn;
	}
	
	public static int cube(int n) {
		return n * n * n;
	}
	
	public static int primeCubePartnershipThree(int limit) {
		int n = 1;
		int toReturn = 0;
		while (limit > 0) {
			int diff = cube(n + 1) - cube(n);
			if (diff >= limit) {
				break;
			} else if (isPrime(diff)) {
				toReturn++;
				// System.out.println(n);
			}
			n++;
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		// System.out.println(check(19, 2));
		// System.out.println(isPrime(91));
		System.out.println("Ausgabe: " + primeCubePartnershipThree(1000000));
	}
	
	/* Remark: My solution should have worked, but it didn't. How and why? I have no clue. I had to find an alternative
	 * algorithm in the internet.
	 * Problem solved
	 * 8477th person to have solved this problem
	 * Problem level: 11
	 * Runtime: Less than 1 second
	 * */
}
