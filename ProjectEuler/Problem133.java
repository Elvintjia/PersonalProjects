package eulerProject121to150;

import java.util.ArrayList;

public class Problem133 {
	public static int repunitDivisibility(int n) {
		if (n % 2 == 0 || n % 5 == 0) {
			return 0;
		}
		int toReturn = 1;
		int remainder = 1;
		while (remainder > 0) {
			if (remainder >= n) {
				remainder -= n;
			} else {
				remainder = remainder * 10 + 1;
				toReturn++;
			}
		}
		return toReturn;
	}
	
	public static ArrayList<Integer> erasthothenesSieve(int n) {
		if (n < 2) {
			return null;
		}
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
		ArrayList<Integer> toReturn = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (array[i] > 0) {
				toReturn.add(array[i]);
			}
		}
		return toReturn;
	}
	
	public static boolean factorOfTen(int n) {
		if (n < 2) {
			return false;
		}
		while (n % 5 == 0) {
			n /= 5;
		}
		while (n % 2 == 0) {
			n /= 2;
		}
		return (n == 1);
	}
	
	public static long repunitNonfactors(int n) {
		ArrayList<Integer> sieve = erasthothenesSieve(n);
		long toReturn = 0;
		while (!sieve.isEmpty()) {
			int temp = sieve.removeFirst();
			int temp2 = repunitDivisibility(temp);
			if (!factorOfTen(temp2)) {
				toReturn += temp;
				// System.out.println(temp);
			}
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		System.out.println("Ausgabe: " + repunitNonfactors(100000));
	}
	
	/*
	 * Problem solved
	 * 6425th person to have solved this problem
	 * Problem level: 13
	 * Runtime: 3 seconds
	 * */
}
